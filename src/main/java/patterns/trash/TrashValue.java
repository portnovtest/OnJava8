package patterns.trash;

import java.util.List;

public class TrashValue {
    private static double total;

    public static void sum(List<? extends Trash> bin, String type) {
        total = 0.0;
        bin.forEach(t -> {
            System.out.println(t);
            total += t.weight * t.price();
        });
        System.out.printf("Total %s value = %.2f%n", type, total);
    }
}
