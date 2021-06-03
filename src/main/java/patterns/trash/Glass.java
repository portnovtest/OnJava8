package patterns.trash;

public class Glass extends Trash {
    public Glass(double wt) {
        super(wt);
    }

    @Override
    public double price() {
        return Price.GLASS;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
