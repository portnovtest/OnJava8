package iostreams;

// {VisuallyInspectOutput}

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(
                "src/main/java/iostreams/FormattedMemoryInput.java").getBytes()))) {
            while (true) {
                System.out.write((char) in.readByte());
            }
        } catch (EOFException e) {
            System.out.println("\nEnd of stream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
