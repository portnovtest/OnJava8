package collections;

// All collections work with for-in

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ForInCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
    }
}
