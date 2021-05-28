package concurrent;

import java.util.stream.Stream;

public class StreamExceptions {
    static Stream<Breakable> test(String id, int failcount) {
        return Stream.of(new Breakable(id, failcount))
                .map(Breakable::work)
                .map(Breakable::work)
                .map(Breakable::work)
                .map(Breakable::work);
    }

    public static void main(String[] args) {
        // No operations are even applied ...
        test("A", 1);
        test("B", 2);
        Stream<Breakable> c = test("C", 3);
        test("D", 4);
        test("E", 5);
        // until there's a terminal operation:
        System.out.println("Entering try");
        try {
            c.forEach(System.out::println);     // [1]
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
