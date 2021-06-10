package iostreams;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/iostreams/Data.txt")))) {
            out.writeDouble(3.14159);
            out.writeUTF("That was pi");
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("src/main/java/iostreams/Data.txt")))) {
            System.out.println(in.readDouble());
            // Only readUTF() will recover the Java-UTF String properly:
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
