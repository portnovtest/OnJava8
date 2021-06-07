package references;

// Cloning a composed object

public class DepthReading implements Cloneable {
    private double depth;

    public DepthReading(double depth) {
        this.depth = depth;
    }

    @Override
    public DepthReading clone() {
        try {
            return (DepthReading) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return String.valueOf(depth);
    }
}
