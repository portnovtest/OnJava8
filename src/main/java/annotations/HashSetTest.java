package annotations;

// {java onjava.atunit.AtUnit
// build/classes/java/main/annotations/HashSetTest.class}

import onjava.atunit.Test;

import java.util.HashSet;

public class HashSetTest {
    HashSet<String> testObject = new HashSet<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void tContains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    void tRemove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }
}
