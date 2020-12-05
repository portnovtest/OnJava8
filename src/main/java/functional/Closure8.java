package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure8 c7 = new Closure8();
        List<Integer> li1 = c7.makeFun().get(),
                li2 = c7.makeFun().get();
        System.out.println(li1);
        System.out.println(li2);
        li1.add(42);
        li2.add(96);
        System.out.println(li1);
        System.out.println(li2);
    }
}
