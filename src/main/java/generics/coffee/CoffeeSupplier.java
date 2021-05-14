package generics.coffee;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

// {java generics.coffee.CoffeeSupplier}

public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {
    private Class<?>[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class,};
    private static Random rand = new Random(47);

    public CoffeeSupplier() {
    }

    // For iteration:
    private int size = 0;

    public CoffeeSupplier(int sz) {
        size = sz;
    }

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].getConstructor().newInstance();
            // Report programmer errors at run time:
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier())
                .limit(5)
                .forEach(System.out::println);
        for (Coffee c : new CoffeeSupplier(5))
            System.out.println(c);
    }
}
