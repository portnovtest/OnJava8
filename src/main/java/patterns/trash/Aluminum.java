package patterns.trash;

public class Aluminum extends Trash {
    public Aluminum(double wt) {
        super(wt);
    }

    @Override
    public double price() {
        return Price.ALUMINUM;
    }

    // Ignore for now; to be used later:
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
