package reuse;

public class SpaceShipDelegation {
    private String name;
    private final SpaceshipControls controls = new SpaceshipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    // Delegated methods:
    public void back(int velocity) {
        controls.back(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void turboBoost(int velocity) {
        controls.turboBoost();
    }

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }
}
