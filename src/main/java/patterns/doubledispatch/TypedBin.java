package patterns.doubledispatch;

// A list that can grab the right type.

import patterns.trash.Trash;

import java.util.ArrayList;
import java.util.List;

public class TypedBin {
    private List<Trash> typedBin = new ArrayList<>();
    public final String type;

    public TypedBin(String type) {
        this.type = type;
    }

    public List<Trash> bin() {
        // Returns a copy of typedBin:
        return new ArrayList<>(typedBin);
    }

    protected boolean addIt(Trash t) {
        typedBin.add(t);
        return true;
    }

    public boolean add(Aluminum a) {
        return false;
    }

    public boolean add(Paper a) {
        return false;
    }

    public boolean add(Glass a) {
        return false;
    }

    public boolean add(Cardboard a) {
        return false;
    }
}
