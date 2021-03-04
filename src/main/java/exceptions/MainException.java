package exceptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainException {
    // Pass exceptions to the console:
    public static void main(String[] args) throws Exception {
        // Open the file:
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/exceptions/MainException.java"));
        // Use this file...
    }
}
