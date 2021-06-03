package patterns;

// State with different compositional interface.

class FloorCleaner {
    private Attachment attachment = new Vacuum();

    public void change(Attachment newAttachment) {
        attachment = newAttachment;
    }

    public void clean() {
        attachment.action();
    }
}

interface Attachment {
    void action();
}

class Vacuum implements Attachment {

    @Override
    public void action() {
        System.out.println("Vacuuming");
    }
}

class Mop implements Attachment {

    @Override
    public void action() {
        System.out.println("Mopping");
    }
}

public class CleanTheFloor {
    public static void main(String[] args) {
        FloorCleaner floorCleaner = new FloorCleaner();
        floorCleaner.clean();
        floorCleaner.change(new Mop());
        floorCleaner.clean();
    }
}
