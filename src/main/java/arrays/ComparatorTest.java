package arrays;

// Implementing a Comparator for a class

import java.util.Arrays;
import java.util.Comparator;

import static onjava.ArrayShow.show;

class CompTypeComparator implements Comparator<CompType> {

    @Override
    public int compare(CompType o1, CompType o2) {
        return Integer.compare(o1.j, o2.j);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> CompType.get());
        show("Before sorting", a);
        Arrays.sort(a, new CompTypeComparator());
        show("After sorting", a);
    }
}
