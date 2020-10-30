package interfaces.interfaceprocessor;


import java.util.Arrays;

// {java interfaces.interfaceprocessor.StringProcessor}
interface StringProcessor extends Processor {
    @Override
    String process(Object input); // [1]

    String S = // [2]
            "If she weighs the same as a duck, " +
                    "she's made of wood";

    static void main(String[] args) { // [3]
        Applicator.apply(new Upcase(), S);
        Applicator.apply(new Downcase(), S);
        Applicator.apply(new Splitter(), S);
    }
}

class Upcase implements StringProcessor {
    @Override // Covariant return:
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
    @Override
    public String process(Object input) {
        // split() divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}
