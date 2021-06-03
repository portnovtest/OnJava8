package patterns.trash;


public class Paper extends Trash {
    public Paper(double wt) {
        super(wt);
    }

    @Override
    public double price() {
        return Price.PAPER;
    }

    // Ignore for now; to be used later:
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
