package generics;

// {WillNotCompile}

public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {
//        // error: illegal generic type for instanceof
//        if (arg instanceof T){}
//
//        // error: unexpected type
//        T var = new T();
//
//        // error: generic array creation
//        T[] array = new T[SIZE];
//
//        // warning: [unchecked] unchecked
//        T[] array = (T[]) new Object[SIZE];
    }
}
