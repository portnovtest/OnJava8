package concurrent;

import java.util.concurrent.Callable;

public class CountingTask implements Callable<Integer> {
    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
        return val;
    }
}
