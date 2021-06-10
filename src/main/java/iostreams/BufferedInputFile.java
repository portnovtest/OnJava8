package iostreams;

// {VisuallyInspectOutput}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class BufferedInputFile {
    public static String read(String filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            return in.lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(read("src/main/java/iostreams/BufferedInputFile.java"));
    }
}
