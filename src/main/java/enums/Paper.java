package enums;

import static enums.Outcome.*;

public class Paper implements Item {

    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors s) {
        return WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}
