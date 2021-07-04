package lowlevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if (trigger < that.trigger) {
            return -1;
        }
        if (trigger > that.trigger) {
            return 1;
        }
        return 0;
    }

    @Override
    public void run() {
        System.out.print(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%d] Task %d", delta, id);
    }

    public String summary() {
        return String.format("(%d:%d)", id, delta);
    }

    public static class EndTask extends DelayedTask {
        EndTask(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            sequence.forEach(dt -> System.out.println(dt.summary()));
        }
    }
}

public class DelayQueueDemo {
    public static void main(String[] args) throws Exception {
        DelayQueue<DelayedTask> tasks = Stream.concat( // Random delays:
                new Random(47).ints(20, 0, 4000)
                        .mapToObj(DelayedTask::new),
                // Add the summarizing task:
                Stream.of(new DelayedTask.EndTask(4000)))
                .collect(Collectors.toCollection(DelayQueue::new));
        while (tasks.size() > 0) {
            tasks.take().run();
        }

    }
}
