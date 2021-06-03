package patterns.trash;

// Related algorithms packaged in each implementation of Visitor.
// {java patterns.trash.TrashVisitor}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PriceVisitor extends Visitor {

    public PriceVisitor() {
        super("price");
    }

    @Override
    void visit(Aluminum al) {
        double price = al.weight * al.price();
        show("Aluminum", price);
        alTotal += price;
    }

    @Override
    void visit(Paper p) {
        double price = p.weight * p.price();
        show("Paper", price);
        pTotal += price;
    }

    @Override
    void visit(Glass g) {
        double price = g.weight * g.price();
        show("Glass", price);
        gTotal += price;
    }

    @Override
    void visit(Cardboard c) {
        double price = c.weight * c.price();
        show("Cardboard", price);
        cTotal += price;
    }
}

class WeightVisitor extends Visitor {
    public WeightVisitor() {
        super("weight");
    }

    @Override
    void visit(Aluminum al) {
        show("Aluminum", al.weight);
        alTotal += al.weight;
    }

    @Override
    void visit(Paper p) {
        show("Paper", p.weight);
        pTotal += p.weight;
    }

    @Override
    void visit(Glass g) {
        show("Glass", g.weight);
        gTotal += g.weight;
    }

    @Override
    void visit(Cardboard c) {
        show("Cardboard", c.weight);
        cTotal += c.weight;
    }
}

public class TrashVisitor {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("trash", bin);
        List<Visitor> visitors = Arrays.asList(
                new PriceVisitor(), new WeightVisitor()
        );
        bin.forEach(
                trash -> visitors.forEach(trash::accept)
        );
        visitors.forEach(Visitor::total);
    }
}
