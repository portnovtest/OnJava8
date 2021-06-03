package patterns.shapes;

import java.util.stream.Stream;

public class FactoryTest {
    public static void test(FactoryMethod factory) {
        Stream.of("Circle", "Square", "Triangle", "Square", "Circle", "Circle", "Triangle")
                .map(factory::create)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count(); // Terminal operation
    }
}
