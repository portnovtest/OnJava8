package annotations;

// Assertions and exceptions can be used in @Tests
// {java onjava.atunit.AtUnit
// build/classes/java/main/annotations/AtUnitExample2.class}

import onjava.atunit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class AtUnitExample2 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test
    void assertFailureExample() {
        assert 1 == 2 : "What a surprise!";
    }

    @Test
    void exceptionExample() throws IOException {
        try (FileInputStream fis = new FileInputStream("nofile.txt")) {
        } // Throws
    }

}
