package collectiontopics;

// A more complex use of PriorityQueue

import java.util.PriorityQueue;

class ToDoItem implements Comparable<ToDoItem> {
    private char primary;
    private int secondary;
    private String item;

    ToDoItem(String td, char pri, int sec) {
        primary = pri;
        secondary = sec;
        item = td;
    }

    @Override
    public int compareTo(ToDoItem arg) {
        if (primary > arg.primary) {
            return +1;
        }
        if (primary == arg.primary) {
            if (secondary > arg.secondary) {
                return +1;
            } else if (secondary == arg.secondary) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Character.toString(primary) + secondary + ": " + item;
    }
}

public class ToDoList {
    public static void main(String[] args) {
        PriorityQueue<ToDoItem> toDo = new PriorityQueue<>();
        toDo.add(new ToDoItem("Empty trash", 'C', 4));
        toDo.add(new ToDoItem("Feed dog", 'A', 2));
        toDo.add(new ToDoItem("Feed bird", 'B', 7));
        toDo.add(new ToDoItem("Mow lawn", 'C', 3));
        toDo.add(new ToDoItem("Water lawn", 'A', 1));
        toDo.add(new ToDoItem("Feed cat", 'B', 1));
        while (!toDo.isEmpty()) {
            System.out.println(toDo.remove());
        }
    }
}
