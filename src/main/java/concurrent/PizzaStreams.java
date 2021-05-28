package concurrent;

import onjava.Timer;

import java.util.stream.IntStream;

public class PizzaStreams {
    static final int QUANTITY = 5;

    public static void main(String[] args) {
        Timer timer = new Timer();
        IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .parallel()     // [1]
                .forEach(za -> {
                    while (!za.complete()) {
                        za.next();
                    }
                });
        System.out.println(timer.duration());
    }
}
