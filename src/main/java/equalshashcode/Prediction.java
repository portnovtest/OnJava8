package equalshashcode;

import java.util.Random;

public class Prediction {
    private static Random rand = new Random(47);

    @Override
    public String toString() {
        return rand.nextBoolean() ? "Six more weeks of Winter!" : "Early Spring!";
    }
}
