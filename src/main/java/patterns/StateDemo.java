package patterns;

// Basic demonstration of the State pattern.

class State {
    private State implementation;

    protected State() {

    }

    public State(State imp) {
        implementation = imp;
    }

    public void change(State newImp) {
        implementation = newImp;
    }

    // Forward method calls to the implementation:
    public void f() {
        implementation.f();
    }

    public void g() {
        implementation.g();
    }

    public void h() {
        implementation.h();
    }
}

class Implementation1 extends State {
    @Override
    public void f() {
        System.out.println("Implementation1.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation1.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation1.h()");
    }
}

class Implementation2 extends State {
    @Override
    public void f() {
        System.out.println("Implementation2.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation2.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation2.h()");
    }
}

public class StateDemo {
    static void test(State s) {
        s.f();
        s.g();
        s.h();
    }

    public static void main(String[] args) {
        State s = new State(new Implementation1());
        test(s);
        System.out.println("Changing implementation");
        s.change(new Implementation2());
        test(s);
    }
}
