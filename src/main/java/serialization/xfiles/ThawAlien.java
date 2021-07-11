package serialization.xfiles;

// Recover a serialized file
// {java serialization.xfiles.ThawAlien}
// {RunFirst: FreezeAlien}

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("src/main/java/serialization/X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
