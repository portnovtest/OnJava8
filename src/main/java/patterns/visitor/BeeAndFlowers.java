package patterns.visitor;

// Demonstration of the Visitor pattern.
// {java patterns.visitor.BeeAndFlowers}

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Visitor {
    void visit(Gladiolus g);

    void visit(Ranunculus r);

    void visit(Chrysanthemum c);


}

// The Flower hierarchy cannot be changed:
interface Flower {
    void accept(Visitor v);
}

class Gladiolus implements Flower {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Ranunculus implements Flower {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Chrysanthemum implements Flower {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

// Add the ability to produce a String:
class StringVal implements Visitor {
    private String s;

    @Override
    public String toString() {
        return s;
    }

    @Override
    public void visit(Gladiolus g) {
        s = "Gladiolus";
    }

    @Override
    public void visit(Ranunculus r) {
        s = "Ranunculus";
    }

    @Override
    public void visit(Chrysanthemum c) {
        s = "Chrysanthemum";
    }
}

// Add the ability to do "Bee" activities:
class Bee implements Visitor {

    @Override
    public void visit(Gladiolus g) {
        System.out.println("Bee and Gladiolus");
    }

    @Override
    public void visit(Ranunculus r) {
        System.out.println("Bee and Ranunculus");
    }

    @Override
    public void visit(Chrysanthemum c) {
        System.out.println("Bee and Chrysanthemum");
    }
}

class FlowerFactory {
    static List<Supplier<Flower>> flowers = Arrays.asList(Gladiolus::new, Ranunculus::new, Chrysanthemum::new);
    static final int SZ = flowers.size();
    private static SplittableRandom rand = new SplittableRandom(47);

    public static Flower newFlower() {
        return flowers.get(rand.nextInt(SZ)).get();
    }
}

public class BeeAndFlowers {
    public static void main(String[] args) {
        List<Flower> flowers = Stream.generate(FlowerFactory::newFlower)
                .limit(10)
                .collect(Collectors.toList());
        StringVal sval = new StringVal();
        flowers.forEach(f -> {
            f.accept(sval);
            System.out.println(sval);
        });
        // Perform "Bee" operation on all Flowers:
        Bee bee = new Bee();
        flowers.forEach(f -> f.accept(bee));
    }
}
