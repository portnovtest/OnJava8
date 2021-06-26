package onjava;

// List of any length, containing sample data
// {java onjava.CountingIntegerList}

import java.util.AbstractList;
import java.util.List;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList() {
        size = 0;
    }

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        List<Integer> cil = new CountingIntegerList(30);
        System.out.println(cil);
        System.out.println(cil.get(500));
    }
}
