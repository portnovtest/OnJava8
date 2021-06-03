package patterns.observer;

// Demonstration of the Observer pattern.
// {java patterns.observer.ObservedFlower}

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
class Flower {
    private boolean isOpen = false;
    private boolean alreadyOpen = false;
    private boolean alreadyClosed = false;
    Observable opening = new Observable() {
        @Override
        public void notifyObservers() {
            if (isOpen && !alreadyOpen) {
                setChanged();
                super.notifyObservers();
                alreadyOpen = true;
            }
        }
    };
    Observable closing = new Observable() {
        @Override
        public void notifyObservers() {
            if (!isOpen && !alreadyClosed) {
                setChanged();
                super.notifyObservers();
                alreadyClosed = true;
            }
        }
    };

    public void open() { // opens its petals
        isOpen = true;
        opening.notifyObservers();
        alreadyClosed = false;
    }

    public void close() { // closes its petals
        isOpen = false;
        closing.notifyObservers();
        alreadyOpen = false;
    }
}

@SuppressWarnings("deprecation")
class Bee {
    private String id;

    Bee(String name) {
        id = name;
    }

    // Observe openings:
    public final Observer whenOpened = (ob, a) -> System.out.println("Bee " + id + "'s breakfast time!");
    // Observe closings:
    public final Observer whenClosed = (ob, a) -> System.out.println("Bee " + id + "'s bed time!");
}

@SuppressWarnings("deprecation")
class Hummingbird {
    private String id;

    Hummingbird(String name) {
        id = name;
    }

    // Observe openings:
    public final Observer whenOpened = (ob, a) -> System.out.println("Hummingbird " + id + "'s breakfast time!");
    // Observe closings:
    public final Observer whenClosed = (ob, a) -> System.out.println("Hummingbird " + id + "'s bed time!");
}

public class ObservedFlower {
    public static void main(String[] args) {
        Flower f = new Flower();
        Bee ba = new Bee("A"),
                bb = new Bee("B");
        Hummingbird ha = new Hummingbird("A"),
                hb = new Hummingbird("B");
        f.opening.addObserver(ha.whenOpened);
        f.opening.addObserver(hb.whenOpened);
        f.opening.addObserver(ba.whenOpened);
        f.opening.addObserver(bb.whenOpened);
        f.closing.addObserver(ha.whenClosed);
        f.closing.addObserver(hb.whenClosed);
        f.closing.addObserver(ba.whenClosed);
        f.closing.addObserver(bb.whenClosed);
        // Hummingbird B decides to sleep in.
        // Removing whenOpened stops open updates.
        f.opening.deleteObserver(hb.whenOpened);
        // A change that interests observers:
        f.open();
        f.open(); // No effect: it's already open.
        System.out.println("-----------------");
        // Bee A doesn't want to go to bed.
        // Removing whenClosed stops closed updates.
        f.closing.deleteObserver(ba.whenClosed);
        f.close();
        System.out.println("+++++++++++++++++");
        f.close(); // No effect: it's already closed.
        System.out.println("=================");
        f.opening.deleteObservers();
        f.open(); // No observers to update.
        System.out.println("#################");
        f.close(); // Close observers are still there.
    }

}
