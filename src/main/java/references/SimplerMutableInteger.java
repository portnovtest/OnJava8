package references;

// A trivial wrapper class

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IntValue2 {
    public int n;

    IntValue2(int n) {
        this.n = n;
    }
}

public class SimplerMutableInteger {
    public static void main(String[] args) {
        List<IntValue2> v = IntStream.range(0, 10)
                .mapToObj(IntValue2::new)
                .collect(Collectors.toList());
        v.forEach(iv2 -> System.out.print(iv2.n + " "));
        System.out.println();
        v.forEach(iv2 -> iv2.n += 1);
        v.forEach(iv2 -> System.out.print(iv2.n + " "));
    }
}
