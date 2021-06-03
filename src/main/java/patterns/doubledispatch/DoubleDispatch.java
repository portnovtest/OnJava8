package patterns.doubledispatch;

// using multiple dispatching to handle more than one unknown type during a method call.
// {java patterns.doubledispatch.DoubleDispatch}

import patterns.trash.ParseTrash;
import patterns.trash.Trash;
import patterns.trash.TrashValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AluminumBin extends TypedBin {
    public AluminumBin() {
        super("Aluminum");
    }

    @Override
    public boolean add(Aluminum a) {
        return addIt(a);
    }
}

class PaperBin extends TypedBin {
    public PaperBin() {
        super("Paper");
    }

    @Override
    public boolean add(Paper a) {
        return addIt(a);
    }
}

class GlassBin extends TypedBin {
    public GlassBin() {
        super("Glass");
    }

    @Override
    public boolean add(Glass a) {
        return super.addIt(a);
    }
}

class CardboardBin extends TypedBin {
    public CardboardBin() {
        super("Cardboard");
    }

    @Override
    public boolean add(Cardboard a) {
        return super.addIt(a);
    }
}

class TrashBinSet {
    public final List<TypedBin> binSet = Arrays.asList(
            new AluminumBin(), new PaperBin(), new GlassBin(), new CardboardBin()
    );

    @SuppressWarnings("unchecked")
    public void sortIntoBins(List<?> bin) {
        bin.forEach(aBin -> {
            TypedBinMember t = (TypedBinMember) aBin;
            if (!t.addToBin(binSet)) {
                throw new RuntimeException("sortIntBins() couldn't add " + t);
            }
        });
    }
}

public class DoubleDispatch {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("doubledispatch", bin);
        TrashBinSet bins = new TrashBinSet();
        // Sort from the master bin into the individually-typed bins:
        bins.sortIntoBins(bin);
        // Sum value of each bin...
        bins.binSet.forEach(tb -> TrashValue.sum(tb.bin(), tb.type));
        // ... and for the master bin:
        TrashValue.sum(bin, "Trash");
    }
}
