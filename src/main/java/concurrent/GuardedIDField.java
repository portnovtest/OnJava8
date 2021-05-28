package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class GuardedIDField implements HasID {
    private static AtomicInteger counter = new AtomicInteger();
    private int id = counter.getAndIncrement();

    @Override
    public int getID() {
        return id;
    }

    public static void main(String[] args) {
        IDChecker.test(GuardedIDField::new);
    }
}
