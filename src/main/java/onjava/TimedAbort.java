package onjava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

// Terminate a program after t seconds
public class TimedAbort {
    private volatile boolean restart = true;

    public TimedAbort(double t, String msg) {
        CompletableFuture.runAsync(() -> {
            try {
                while (restart) {
                    restart = false;
                    TimeUnit.MILLISECONDS.sleep((int) (1000 * t));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
            System.exit(0);
        });
    }

    public TimedAbort(double t) {
        this(t, "TimedAbort " + t);
    }

    public void restart() {
        restart = true;
    }
}
