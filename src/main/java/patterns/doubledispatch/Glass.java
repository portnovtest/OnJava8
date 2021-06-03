package patterns.doubledispatch;

import java.util.List;

public class Glass extends patterns.trash.Glass implements TypedBinMember {
    public Glass(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
