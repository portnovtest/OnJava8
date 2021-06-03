package patterns.trash;

// Opens a file and parses its contents into Trash objects, placing each into a Fillable.
// {java patterns.trash.ParseTrash}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseTrash {
    public static String source = "Trash.dat";

    public static <T extends Trash> void fillBin(String packageName, Fillable<T> bin) {
        DynaFactory factory = new DynaFactory(packageName);
        try {
            Files.lines(Paths.get("src/main/java/patterns/trash", source))
                    // Remove comments and empty lines:
                    .filter(line -> line.trim().length() != 0)
                    .filter(line -> !line.startsWith("//"))
                    .forEach(line -> {
                        String type = line.substring(0, line.indexOf(':')).trim();
                        double weight = Double.parseDouble(line.substring(line.indexOf(':') + 1)
                                .trim());
                        bin.addTrash(factory.create(new TrashInfo(type, weight)));
                    });
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    // Special case to handle a List:
    public static <T extends Trash> void fillBin(String packageName, List<T> bin) {
        fillBin(packageName, new FillableList<>(bin));
    }

    // Basic test:
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        fillBin("trash", bin);
        bin.forEach(System.out::println);
    }
}
