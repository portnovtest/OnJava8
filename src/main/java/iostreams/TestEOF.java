package iostreams;

// Testing for end of file
// {VisuallyInspectOutput}

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("src/main/java/iostreams/TestEOF.java")))) {
            while (in.available() != 0) {
                System.out.write(in.readByte());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
