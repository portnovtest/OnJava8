package patterns;

class MyString {
    private String s;

    public MyString(String s) {
        this.s = s;
    }

    public synchronized void change(String s) {
        this.s = s;
    }

    @Override
    public synchronized String toString() {
        return s;
    }
}

public class SingletonPattern3 {
    public static void main(String[] args) {
        Single<MyString> x = new Single<>(new MyString("Hello"));
        System.out.println(x.get());
        x.get().change("World!");
        System.out.println(x.get());
    }
}
