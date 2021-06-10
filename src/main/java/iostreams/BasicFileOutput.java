package iostreams;

// {VisuallyInspectOutput}

import java.io.*;

public class BasicFileOutput {
    static String file = "src/main/java/iostreams/BasicFileOutput.dat";

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(
                "src/main/java/iostreams/BasicFileOutput.java")));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
