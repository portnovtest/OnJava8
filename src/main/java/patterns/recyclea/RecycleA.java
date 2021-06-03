package patterns.recyclea;

// Recycling with reflection.
// {java patterns.recyclea.RecycleA}

import patterns.trash.*;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SimpleFactory {
    static final List<Function<Double, Trash>> constructors = Arrays.asList(Aluminum::new, Paper::new, Glass::new);
    static final int SIZE = constructors.size();
    private static SplittableRandom rand = new SplittableRandom(42);

    public static Trash random() {
        return constructors.get(rand.nextInt(SIZE)).apply(rand.nextDouble());
    }
}

public class RecycleA {
    public static void main(String[] args) {
        List<Trash> bin = Stream.generate(SimpleFactory::random)
                .limit(10)
                .collect(Collectors.toList());
        Bins bins = new Bins(bin);
        bins.show();
    }
}
