package patterns.trash;

// Using a Map of Lists and reflection to sort Trash into Lists. This is extensible, despite the use of reflection.
// {java patterns.trash.TypeMapTrash}

import patterns.TypeMap;

// Adapter class for ParseTrash.fillBin():
class TypeMapAdapter implements Fillable {
    private TypeMap<Trash> map;

    TypeMapAdapter(TypeMap<Trash> map) {
        this.map = map;
    }

    @Override
    public void addTrash(Trash t) {
        map.add(t);
    }
}

public class TypeMapTrash {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        TypeMap<Trash> bin = new TypeMap<>();
        ParseTrash.fillBin("trash", new TypeMapAdapter(bin));
        ClassToListOfTrashMap.show(bin.map);
    }
}
