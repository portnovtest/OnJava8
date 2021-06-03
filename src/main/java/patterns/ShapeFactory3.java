package patterns;

// Polymorphic factory methods.

import patterns.shapes.Circle;
import patterns.shapes.Shape;
import patterns.shapes.Square;
import patterns.shapes.Triangle;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

interface PolymorphicFactory {
    Shape create();
}

class RandomShapes implements Supplier<Shape> {
    private final PolymorphicFactory[] factories;
    private Random rand = new Random(42);

    RandomShapes(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    @Override
    public Shape get() {
        return factories[rand.nextInt(factories.length)].create();
    }
}

public class ShapeFactory3 {
    public static void main(String[] args) {
        RandomShapes rs = new RandomShapes( // [1]
                Circle::new, Square::new, Triangle::new
        );
        Stream.generate(rs)
                .limit(6)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count();
    }
}
