package onjava;

import java.util.Arrays;

import static onjava.Range.range;

// Basic test of Range.java

public class TestRange {
    private static void show(int[] rng) {
        System.out.println(Arrays.toString(rng));
    }

    public static void main(String[] args) {
        show(range(10, 21, 3));
        show(range(21, 10, -3));
        show(range(-5, 5, -3));
        show(range(-5, 5, 3));
        show(range(10, 21));
        show(range(10));
    }
}
