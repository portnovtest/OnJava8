package concurrent;

// Hidden deadlock
// {ExcludeFromGradle} Gradle has trouble

import onjava.Nap;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class DiningPhilosophers {
    private StickHolder[] sticks;
    private Philosopher[] philosophers;

    public DiningPhilosophers(int n) {
        sticks = new StickHolder[n];
        Arrays.setAll(sticks, i -> new StickHolder());
        philosophers = new Philosopher[n];
        Arrays.setAll(philosophers, i -> new Philosopher(i, sticks[i], sticks[(i + 1) % n])); // [1]
        // Fix by reversing stick order from this one:
        // philosophers[1] = new Philosopher(0, sticks[0], sticks[1]);  // [2]
        Arrays.stream(philosophers)
                .forEach(CompletableFuture::runAsync);  // [3]
    }

    public static void main(String[] args) {
        // Returns right away:
        new DiningPhilosophers(5);  // [4]
        // Keep main() from exiting:
        new Nap(3, "Shutdown");
    }
}
