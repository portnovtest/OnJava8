package generics;

public class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
