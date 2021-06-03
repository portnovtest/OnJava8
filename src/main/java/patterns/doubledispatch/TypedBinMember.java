package patterns.doubledispatch;

// Adopts the double-dispatching method into the trash hierarchy without modifying the original hierarchy.

import java.util.List;

public interface TypedBinMember {
    boolean addToBin(List<TypedBin> bins);
}
