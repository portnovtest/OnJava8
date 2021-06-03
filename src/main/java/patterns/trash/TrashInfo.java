package patterns.trash;

public class TrashInfo {
    public final String type;
    public final double data;

    public TrashInfo(String type, double data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "TrashInfo(" + type + ", " + data + ")";
    }
}
