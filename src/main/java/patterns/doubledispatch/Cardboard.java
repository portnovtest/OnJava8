package patterns.doubledispatch;

import java.util.List;

public class Cardboard extends patterns.trash.Cardboard implements TypedBinMember {
    public Cardboard(double wt) {
        super(wt);
    }

    @Override
    public boolean addToBin(List<TypedBin> tbins) {
        return tbins.stream()
                .anyMatch(tb -> tb.add(this));
    }
}
