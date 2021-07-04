package lowlevel;

public class UnsafeReturn extends IntTestable {
    private int i = 0;

    public int getAsInt() {
        return i;
    }

    @Override
    void evenIncrement() {
        i++;
        i++;
    }

    public static void main(String[] args) {
        Atomicity.test(new UnsafeReturn());
    }
}
