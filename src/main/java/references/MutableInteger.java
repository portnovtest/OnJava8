package references;

// A changeable wrapper class

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IntValue {
    private int n;

    IntValue(int x) {
        n = x;
    }

    public int getValue() {
        return n;
    }

    public void setValue(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class MutableInteger {
    public static void main(String[] args) {
        List<IntValue> v = IntStream.range(0, 10)
                .mapToObj(IntValue::new)
                .collect(Collectors.toList());
        System.out.println(v);
        v.forEach(IntValue::increment);
        System.out.println(v);
    }
}
