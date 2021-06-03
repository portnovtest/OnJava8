package patterns.recyclec;

// {java patterns.recyclec.RecycleC}

import patterns.trash.*;

import java.util.ArrayList;

// A List that only admits the right type:
class TrashBin<T extends Trash> extends ArrayList<T> {
    final Class<T> binType;

    TrashBin(Class<T> binType) {
        this.binType = binType;
    }

    @SuppressWarnings("unchecked")
    boolean grab(Trash t) {
        // Compare class types:
        if (t.getClass().equals(binType)) {
            add((T) t); // Downcast to this TrashBin type
            return true; // Trash grabbed
        }
        return false; // Trash not grabbed
    }
}

class TrashBinList<T extends Trash> extends ArrayList<TrashBin<? extends T>> { // [1]
    @SuppressWarnings("unchecked")
    public TrashBinList(Class<? extends T>... types) {
        for (Class<? extends T> type : types) {
            add(new TrashBin<>(type));
        }
    }

    public boolean sort(T t) {
        for (TrashBin<? extends T> ts : this) {
            if (ts.grab(t)) {
                return true;
            }
        }
        return false; // TrashBin not found for t
    }

    public void sortBin(TrashBin<T> bin) {   // [2]
        for (T trash : bin) {
            if (!sort(trash)) {
                throw new RuntimeException("Bin not found for " + trash);
            }
        }
    }

    public void show() {
        for (TrashBin<? extends T> tbin : this) {
            String typeName = tbin.binType.getSimpleName();
            TrashValue.sum(tbin, typeName);
        }
    }
}

public class RecycleC {
    public static void main(String[] args) {
        TrashBin<Trash> bin = new TrashBin<>(Trash.class);
        ParseTrash.fillBin("trash", bin);
        @SuppressWarnings("unchecked")
        TrashBinList<Trash> trashBins = new TrashBinList<>(
                Aluminum.class, Paper.class, Glass.class,
                // Add one item:
                Cardboard.class     // [3]
        );
        trashBins.sortBin(bin);     // [4]
        trashBins.show();
        TrashValue.sum(bin, "Trash");
    }
}
