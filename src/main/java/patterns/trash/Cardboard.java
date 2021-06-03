package patterns.trash;

public class Cardboard extends Trash {
    public Cardboard(double wt) {
        super(wt);
    }

    @Override
    public double price() {
        return Price.CARDBOARD;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
