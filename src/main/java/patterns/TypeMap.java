package patterns;

// Generic TypeMap works for any types.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TypeMap<T> {
    public final Map<Class, List<T>> map = new HashMap<>();

    public void add(T o) {
        Class type = o.getClass();
        map.computeIfAbsent(type, k -> new ArrayList<>()).add(o);
    }

    public Stream<List<T>> values() {
        return map.values().stream();
    }
}
