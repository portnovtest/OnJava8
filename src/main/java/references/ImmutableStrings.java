package references;

// Demonstrating StringBuilder

public class ImmutableStrings {
    public static void main(String[] args) {
        String foo = "foo";
        String s = "abc" + foo + "def" + Integer.toString(47);
        System.out.println(s);
        // The "equivalent" using StringBuilder:
        StringBuilder sb = new StringBuilder("abc"); // Creates String
        sb.append(foo);
        sb.append("def"); // Creates String
        sb.append(Integer.toString(47));
        System.out.println(sb);
    }
}
