package collections;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/main/java/collections/SetOperations.java"));
        Set<String> words = new TreeSet<>();
        for (String line : lines) {
            for (String word : line.split("\\W+")) {
                if (word.trim().length() > 0) {
                    words.add(word);
                }
            }
        }
        System.out.println(words);
    }
}
