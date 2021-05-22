package enums;

import static enums.Outcome.*;

public class Scissors implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return LOSE;
    }

    @Override
    public Outcome eval(Scissors s) {
        return DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}
