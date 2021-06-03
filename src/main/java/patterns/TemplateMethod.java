package patterns;

// Basic Template Method pattern.

import java.util.stream.IntStream;

abstract class ApplicationFramework {
    ApplicationFramework() {
        templateMethod();
    }

    abstract void customize1(int n);

    abstract void customize2(int n);

    // "private" means automatically "final":
    private void templateMethod() {
        IntStream.range(0, 5).forEach(
                n -> {
                    customize1(n);
                    customize2(n);
                }
        );
    }
}

// Create a new application:
class MyApp extends ApplicationFramework {

    @Override
    void customize1(int n) {
        System.out.print("customize1 " + n);
    }

    @Override
    void customize2(int n) {
        System.out.println(" customize2 " + n);
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        new MyApp();
    }
}
