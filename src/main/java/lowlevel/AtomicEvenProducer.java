package lowlevel;

// Atomic classes: occasionally useful in regular code

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenProducer extends IntGenerator {
    private AtomicInteger currentEventValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEventValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenProducer());
    }
}
