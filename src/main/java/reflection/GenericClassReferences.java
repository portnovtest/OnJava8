package reflection;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        intClass = double.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing
        // genericIntClass = double.class // Illegal
    }
}
