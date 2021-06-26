package collectiontopics;

// Functional operations on a Map

import java.util.Map;

import static onjava.HTMLColors.MAP;

public class FunctionalMap {
    public static void main(String[] args) {
        MAP.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(v -> v.startsWith("Dark"))
                .map(v -> v.replaceFirst("Dark", "Hot"))
                .forEach(System.out::println);
    }
}
