package references;

// The Integer class cannot be changed

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImmutableInteger {
    public static void main(String[] args) {
        @SuppressWarnings("deprecation")
        List<Integer> v = IntStream.range(0, 10)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
        System.out.println(v);
        // But how you change the int inside the Integer?
    }
}
