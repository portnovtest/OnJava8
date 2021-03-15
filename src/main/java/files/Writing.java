package files;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        // Write bytes to a file:
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Files.write(Paths.get("src/main/java/files/bytes.dat"), bytes);
        System.out.println("bytes.dat: " + Files.size(Paths.get("src/main/java/files/bytes.dat")));

        // Write an iterable to a file:
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/streams/Cheese.dat"));
        Files.write(Paths.get("src/main/java/files/Cheese.txt"), lines);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("src/main/java/files/Cheese.txt")));
    }
}
