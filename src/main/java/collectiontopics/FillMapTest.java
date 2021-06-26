package collectiontopics;

import onjava.Count;
import onjava.FillMap;
import onjava.Rand;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FillMapTest {
    public static void main(String[] args) {
        Map<String, Integer> mcs = FillMap.basic(new Rand.String(4), new Count.Integer(), 7);
        System.out.println(mcs);
        HashMap<String, Integer> hashm = FillMap.create(new Rand.String(4), new Count.Integer(), HashMap::new, 7);
        System.out.println(hashm);
        LinkedHashMap<String, Integer> linkm = FillMap.create(new Rand.String(4), new Count.Integer(), LinkedHashMap::new, 7);
        System.out.println(linkm);
    }
}
