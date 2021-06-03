package patterns.trash;

// Any object that can be filled with Trash.

public interface Fillable<T extends Trash> {
    void addTrash(T t);
}
