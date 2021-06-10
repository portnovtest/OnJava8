package iostreams;

// {VisuallyInspectOutput}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String file = "src/main/java/iostreams/FileOutputShortcut.dat";

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("src/main/java/iostreams/FileOutputShortcut.java")));
             // Here's the shortcut:
             PrintWriter out = new PrintWriter(file)
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(BufferedInputFile.read(file));
    }
}
