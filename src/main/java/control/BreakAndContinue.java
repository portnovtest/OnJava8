package control;

import static onjava.Range.range;

public class BreakAndContinue {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) { // [1]
            if (i == 74) break; // Out of for loop
            if (i % 9 != 0) continue; // Next iteration
            System.out.print(i + " ");
        }
        System.out.println();
        // Using for-in:
        for (int i : range(100)) { // [2]
            if (i == 74) break; // Out of for loop
            if (i % 9 != 0) continue; // Next iteration
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 0;
        // An "infinite loop":
        while (true) { // [3]
            i++;
            int j = i * 27;
            if (j == 1269) break; // Out of loop;
            if (i % 10 != 0) continue; // Top of loop;
            System.out.print(i + " ");
        }
    }
}
