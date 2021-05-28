package concurrent;

import onjava.Nap;

import java.util.concurrent.atomic.AtomicBoolean;

public class QuittableTask implements Runnable {
    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get()) {         // [1]
            new Nap(0.1);
        }
        System.out.print(id + " ");   // [2]
    }
}
