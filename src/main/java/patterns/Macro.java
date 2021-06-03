package patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Macro {
    public static void main(String[] args) {
        List<Runnable> macro = new ArrayList<>(
                Arrays.asList(
                        () -> System.out.print("Hello "),
                        () -> System.out.println("World! ")
                )
        );
        macro.forEach(Runnable::run);
        macro.add(() -> System.out.print("I'm the command pattern!"));
        macro.forEach(Runnable::run);
    }
}
