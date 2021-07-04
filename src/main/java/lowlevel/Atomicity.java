package lowlevel;

import onjava.TimedAbort;

import java.util.concurrent.CompletableFuture;

public class Atomicity {
    public static void test(IntTestable it) {
        new TimedAbort(4, "No failures found");
        CompletableFuture.runAsync(it);
        while (true) {
            int val = it.getAsInt();
            if (val % 2 != 0) {
                System.out.println("failed with: " + val);
                System.exit(0);
            }
        }
    }
}
