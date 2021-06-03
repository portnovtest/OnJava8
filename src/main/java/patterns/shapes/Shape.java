package patterns.shapes;

public class Shape {
    private static int counter = 0;
    private int id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + id + "]";
    }

    public void draw() {
        System.out.println(this + " draw");
    }

    public void erase() {
        System.out.println(this + " erase");
    }
}
