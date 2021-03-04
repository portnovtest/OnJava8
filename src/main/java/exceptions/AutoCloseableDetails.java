package exceptions;

class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();

    Reporter() {
        System.out.println("Creating " + name);
    }

    public void close() {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {
}

class Second extends Reporter {
}

public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (First f = new First();
             Second s = new Second()) {
        }
    }
}
