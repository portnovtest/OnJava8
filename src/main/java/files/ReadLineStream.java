package files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineStream {
    public static void main(String[] args) throws Exception {
        Files.lines(Paths.get("src/main/java/files/PathInfo.java"))
                .skip(16)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
