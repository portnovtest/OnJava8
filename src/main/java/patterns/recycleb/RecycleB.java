package patterns.recycleb;

// {java patterns.recycleb.RecycleB}

import patterns.trash.Bins;
import patterns.trash.ParseTrash;
import patterns.trash.Trash;

import java.util.ArrayList;
import java.util.List;

public class RecycleB {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("trash", bin);
        Bins bins = new Bins(bin);
        bins.show();
    }
}
