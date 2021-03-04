package exceptions;

class Third extends Reporter {
}

public class BodyException {
    public static void main(String[] args) {
        try (First f = new First();
             Second s2 = new Second()) {
            System.out.println("In body");
            Third t = new Third();
            new SecondExcept();
            System.out.println("End of body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
