package patterns;

// Demonstration of multiple dispatching.

import enums.*;
import onjava.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static onjava.Tuple.tuple;

class ItemFactory {
    static List<Supplier<Item>> items = Arrays.asList(Scissors::new, Paper::new, Rock::new);
    static final int SZ = items.size();
    private static SplittableRandom rand = new SplittableRandom(47);

    public static Item newItem() {
        return items.get(rand.nextInt(SZ)).get();
    }

    public static Tuple2<Item, Item> newPair() {
        return tuple(newItem(), newItem());
    }
}

class Compete {
    public static Outcome match(Tuple2<Item, Item> p) {
        System.out.print(p.a1 + " -> " + p.a2 + " : ");
        return p.a1.compete(p.a2);
    }
}

public class PaperScissorsRock {
    public static void main(String[] args) {
        Stream.generate(ItemFactory::newPair)
                .limit(20)
                .map(Compete::match)
                .forEach(System.out::println);
    }
}
