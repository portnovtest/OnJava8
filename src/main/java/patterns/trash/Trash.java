package patterns.trash;

// Base class for Trash recycling examples.

public abstract class Trash {
    public final double weight;

    public Trash(double weight) {
        this.weight = weight;
    }

    public abstract double price();

    @Override
    public String toString() {
        return String.format("%s weight: %.2f * price: %.2f = %.2f",
                getClass().getSimpleName(), weight, price(), weight * price());
    }

    // Ignore for now; to be used later:
    public abstract void accept(Visitor v);
}
