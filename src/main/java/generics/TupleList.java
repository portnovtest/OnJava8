package generics;

// Combining generic types to make complex generic types

import onjava.Tuple4;

import java.util.ArrayList;

public class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
        tl.forEach(System.out::println);
    }
}
