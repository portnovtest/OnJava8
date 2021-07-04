package lowlevel;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest extends IntTestable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getAsInt() {
        return i.get();
    }

    @Override
    void evenIncrement() {
        i.addAndGet(2);
    }

    public static void main(String[] args) {
        Atomicity.test(new AtomicIntegerTest());
    }
}
