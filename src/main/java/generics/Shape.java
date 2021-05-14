package generics;

public class Shape {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public void rotate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newResize) {
        System.out.println(this + " resize " + newResize);
    }
}
