package arrays;

// The Collections.reverseOrder() Comparator

import java.util.Arrays;
import java.util.Collections;

import static onjava.ArrayShow.show;

public class Reverse {
    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> CompType.get());
        show("Before sorting", a);
        Arrays.sort(a, Collections.reverseOrder());
        show("After sorting", a);
    }
}
