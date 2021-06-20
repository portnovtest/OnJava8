package equalshashcode;

import java.util.Objects;

class Part {
    String ss;
    double dd;

    Part(String ss, double dd) {
        this.ss = ss;
        this.dd = dd;
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof Part &&
                Objects.equals(ss, ((Part) rval).ss) &&
                Objects.equals(dd, ((Part) rval).dd);
    }
}

public class ComposedEquality extends SuccinctEquality {
    Part part;

    public ComposedEquality(int i, String s, double d) {
        super(i, s, d);
        part = new Part(s, d);
        System.out.println("made 'ComposedEquality'");
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof ComposedEquality && super.equals(rval) && Objects.equals(part, ((ComposedEquality) rval).part);
    }

    public static void main(String[] args) {
        Equality.testAll(ComposedEquality::new);
    }
}
