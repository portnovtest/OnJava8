package patterns.trash;

// Display a Map<Class<?>, List<Trash>>.

import java.util.List;
import java.util.Map;

public class ClassToListOfTrashMap {
    public static void show(Map<Class, List<Trash>> map) {
        map.values().forEach(bin -> {
            String typeName = "Trash";
            if (!bin.isEmpty()) {
                typeName = bin.get(0).getClass().getSimpleName();
            }
            TrashValue.sum(bin, typeName);
        });
    }
}
