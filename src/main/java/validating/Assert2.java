package validating;

// Assert with an information-expression
// {java -ea Assert1}
// {ThrowsException}

public class Assert2 {
    public static void main(String[] args) {
        assert false : "Here's a message saying what happened";
    }
}
