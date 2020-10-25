package reuse;

public class DerivedSpaceship extends SpaceshipControls {
    private String name;

    public DerivedSpaceship(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        DerivedSpaceship protector = new DerivedSpaceship("NSEA Protector");
        protector.forward(100);
    }
}
