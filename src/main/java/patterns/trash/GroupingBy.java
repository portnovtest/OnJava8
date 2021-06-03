package patterns.trash;

// {java patterns.trash.GroupingBy}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("trash", bin);
        Map<Class, List<Trash>> m = bin.stream().collect(
                Collectors.groupingBy(Object::getClass));
        ClassToListOfTrashMap.show(m);
    }
}
