package streams;

import java.util.ArrayList;

public class SpecialCollector {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words =
                FileToWords.stream("src/main/java/streams/Cheese.dat")
                        .collect(ArrayList::new,
                                ArrayList::add,
                                ArrayList::addAll);
        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}
