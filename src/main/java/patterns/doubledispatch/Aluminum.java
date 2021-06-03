package patterns.doubledispatch;

// Aluminum with double dispatching.

import java.util.List;

public class Aluminum extends patterns.trash.Aluminum implements TypedBinMember {
    public Aluminum(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
