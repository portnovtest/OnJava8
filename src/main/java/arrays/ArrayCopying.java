package arrays;

// Demonstrates Arrays.copy() and Arrays.copyOf()

import onjava.Count;

import java.util.Arrays;

import static onjava.ArrayShow.show;


class Sup { // Superclass
    private int id;

    Sup(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

class Sub extends Sup { // Subclass
    Sub(int n) {
        super(n);
    }
}

public class ArrayCopying {
    public static final int SZ = 15;

    public static void main(String[] args) {
        int[] a1 = new int[SZ];
        Arrays.setAll(a1, new Count.Integer()::get);
        show("a1", a1);
        int[] a2 = Arrays.copyOf(a1, a1.length); // [1]
        // Prove they are distinct arrays:
        Arrays.fill(a1, 1);
        show("a1", a1);
        show("a2", a2);

        // Create a shorter result:
        a2 = Arrays.copyOf(a2, a2.length / 2); // [2]
        show("a2", a2);

        // Also copies wrapped arrays:
        Integer[] a3 = new Integer[SZ]; // [3]
        Arrays.setAll(a3, new Count.Integer()::get);
        Integer[] a4 = Arrays.copyOfRange(a3, 4, 12);
        show("a4", a4);

        Sub[] d = new Sub[SZ / 2];
        Arrays.setAll(d, Sub::new);
        // Produce Sup[] from Sub[]:
        Sup[] b = Arrays.copyOf(d, d.length, Sup[].class); // [4]
        show(b);

        // This "downcast" works fine:
        Sub[] d2 = Arrays.copyOf(b, b.length, Sub[].class); // [5]
        show(d2);

        // Bad "downcast" compiles but throws exception:
        Sup[] b2 = new Sup[SZ / 2];
        Arrays.setAll(b2, Sup::new);
        try {
            Sub[] d3 = Arrays.copyOf(b2, b2.length, Sub[].class); // [6]
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
