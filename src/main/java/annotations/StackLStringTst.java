package annotations;

// Applying @Unit to generics
// {java onjava.atunit.AtUnit
// build/classes/java/main/annotations/StackLStringTst.class}

import onjava.atunit.Test;

public class StackLStringTst extends StackL<String> {
    @Test
    void tPush() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void tPop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void tTop() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }
}
