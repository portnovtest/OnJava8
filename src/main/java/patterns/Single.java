package patterns;

@SuppressWarnings("unchecked")
public final class Single<T> {
    private static Object single;   // [1]

    public Single(T val) {
        if (single != null) {
            throw new RuntimeException("Attempt to reassign Single<" + val.getClass().getSimpleName() + ">");
        }
        single = val;
    }

    public T get() {
        return (T) single;
    }
}
