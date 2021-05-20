package arrays;

import onjava.Rand;

import java.util.Arrays;

public class ParallelSetAll {
    static final int SIZE = 10_000_000;

    static void intArray() {
        int[] ia = new int[SIZE];
        Arrays.setAll(ia, new Rand.Pint()::get);
        Arrays.parallelSetAll(ia, new Rand.Pint()::get);
    }

    static void longArray() {
        long[] la = new long[SIZE];
        Arrays.setAll(la, new Rand.Long()::get);
        Arrays.parallelSetAll(la, new Rand.Long()::get);
    }

    public static void main(String[] args) {
        intArray();
        longArray();
    }
}
