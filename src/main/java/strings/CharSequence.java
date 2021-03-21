package strings;

public interface CharSequence {
    char charAt(int i);

    int length();

    CharSequence subSequence(int start, int end);

    String toString();
}
