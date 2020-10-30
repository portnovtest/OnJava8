package interfaces;

interface Concept { // Package access
    void idea1();

    void idea2();
}

class Implementation implements Concept {
    public void idea1() {
        System.out.println("idea1");
    }

    public void idea2() {
        System.out.println("idea2");
    }
}

public class ImplementingAnInterface {
}
