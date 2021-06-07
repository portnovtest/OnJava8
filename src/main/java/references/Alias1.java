package references;

// Aliasing two references to one object

public class Alias1 {
    private int i;

    public Alias1(int ii) {
        i = ii;
    }

    public static void main(String[] args) {
        Alias1 x = new Alias1(7);
        Alias1 y = x; // Assign the reference   // [1]
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
        System.out.println("Incrementing x");
        x.i++;                                  // [2]
        System.out.println("x: " + x.i);
        System.out.println("y: " + y.i);
    }
}
