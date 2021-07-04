package lowlevel;

import onjava.Nap;
import onjava.TimedAbort;

public class TestAbort {
    public static void main(String[] args) {
        new TimedAbort(1);
        System.out.println("Napping for 4");
        new Nap(4);
    }
}
