package references;

// Cloning a composed object

public class TemperatureReading implements Cloneable {
    private long time;
    private double temperature;

    public TemperatureReading(double temperature) {
        time = System.currentTimeMillis();
        this.temperature = temperature;
    }

    @Override
    protected TemperatureReading clone() {
        try {
            return (TemperatureReading) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temp) {
        this.temperature = temp;
    }

    @Override
    public String toString() {
        return String.valueOf(temperature);
    }
}
