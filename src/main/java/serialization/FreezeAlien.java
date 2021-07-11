package serialization;

// Create a serialized output file

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/java/serialization/X.file"))) {
            Alien quellek = new Alien();
            out.writeObject(quellek);
        }
    }
}
