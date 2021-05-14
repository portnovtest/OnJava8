package generics;

public class Manipulator3 {
    private HasF obj;

    Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
