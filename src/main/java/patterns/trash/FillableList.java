package patterns.trash;

import java.util.List;

// Adapter that makes a list Fillable

public class FillableList<T extends Trash> implements Fillable<T> {
    private List<T> list;

    public FillableList(List<T> list) {
        this.list = list;
    }

    @Override
    public void addTrash(T t) {
        list.add(t);
    }
}
