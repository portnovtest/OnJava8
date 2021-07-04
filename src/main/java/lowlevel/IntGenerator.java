package lowlevel;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IntGenerator {
    private AtomicBoolean canceled = new AtomicBoolean();

    public abstract int next();

    public void cancel() {
        canceled.set(true);
    }

    public boolean isCanceled() {
        return canceled.get();
    }
}
