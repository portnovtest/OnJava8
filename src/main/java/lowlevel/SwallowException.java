package lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SwallowException {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            throw new RuntimeException();
        });
        exec.shutdown();
    }
}
