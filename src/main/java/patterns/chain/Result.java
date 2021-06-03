package patterns.chain;

// Carries the result or indicates failure.

import java.util.Collections;
import java.util.List;

public class Result {
    public final boolean success;
    public final List<Double> line;

    public Result(List<Double> data) {
        success = true;
        line = data;
    }

    private Result() {
        success = false;
        line = Collections.<Double>emptyList();
    }

    public static final Result fail = new Result();
}
