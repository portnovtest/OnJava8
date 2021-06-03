package patterns;

// Basic demonstration of the Proxy pattern.

interface ProxyBase {
    void f();

    void g();

    void h();
}

class Proxy implements ProxyBase {

    private ProxyBase implementation = new Implementation();

    @Override
    public void f() {
        implementation.f();
    }

    @Override
    public void g() {
        implementation.g();
    }

    @Override
    public void h() {
        implementation.h();
    }
}

class Implementation implements ProxyBase {

    @Override
    public void f() {
        System.out.println("implementation.f()");
    }

    @Override
    public void g() {
        System.out.println("implementation.g()");
    }

    @Override
    public void h() {
        System.out.println("implementation.h()");
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Proxy p = new Proxy();
        p.f();
        p.g();
        p.h();
    }
}
