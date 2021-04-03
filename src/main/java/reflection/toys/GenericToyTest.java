package reflection.toys;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftc = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftc.getConstructor().newInstance();
        Class<? super FancyToy> up = ftc.getSuperclass();
        // This won't compile:
        // Class<Toy> up2 = ftc.getSuperclass();
        // Only produces Object:
        Object obj = up.getConstructor().newInstance();
    }
}
