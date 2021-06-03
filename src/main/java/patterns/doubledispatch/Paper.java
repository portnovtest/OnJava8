package patterns.doubledispatch;

// Paper with double dispatching.

import java.util.List;

public class Paper extends patterns.trash.Paper implements TypedBinMember {
    public Paper(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
