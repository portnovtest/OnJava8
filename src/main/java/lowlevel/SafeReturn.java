package lowlevel;

public class SafeReturn extends IntTestable {
    private int i = 0;

    public synchronized int getAsInt() {
        return i;
    }

    @Override
    public synchronized void evenIncrement() {
        i++;
        i++;
    }

    public static void main(String[] args) {
        Atomicity.test(new SafeReturn());
    }
}
