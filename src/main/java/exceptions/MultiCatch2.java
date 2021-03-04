package exceptions;

public class MultiCatch2 {
    void x() throws Except1, Except2, Except3, Except4 {
    }

    void process1() {
    }

    void process2() {
    }

    void f() {
        try {
            x();
        } catch (Except1 | Except2 e) {
            process1();
        } catch (Except3 | Except4 e) {
            process2();
        }
    }
}
