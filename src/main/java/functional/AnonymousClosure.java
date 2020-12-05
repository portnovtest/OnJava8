package functional;

import java.util.function.IntSupplier;

public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        // Same rules apply:
        // i++; // Not "effectively final"
        // x++; // Ditto
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
