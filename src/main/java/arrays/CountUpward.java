package arrays;

import java.util.stream.LongStream;

import static onjava.ArrayShow.show;

public class CountUpward {
    static long[] fillCounted(int size) {
        return LongStream.iterate(0, i -> i + 1)
                .limit(size).toArray();
    }

    public static void main(String[] args) {
        long[] l1 = fillCounted(20); // No problem
        show(l1);
        // On my machine, this runs out of heap space:
        long[] l2 = fillCounted(10_000_000);
        show(l2);
    }
}
