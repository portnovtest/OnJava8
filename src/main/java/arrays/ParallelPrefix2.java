package arrays;

import onjava.Rand;

import java.util.Arrays;

import static onjava.ArrayShow.show;

public class ParallelPrefix2 {
    public static void main(String[] args) {
        String[] strings = new Rand.String(1).array(8);
        show(strings);
        Arrays.parallelPrefix(strings, (a, b) -> a + b);
        show(strings);
    }
}
