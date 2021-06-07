package references;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeepCopyTest {
    @Test
    public void testClone() {
        OceanReading reading = new OceanReading(33.9, 100.5);
        // Now clone it:
        OceanReading clone = reading.clone();
        TemperatureReading tr = clone.getTemperatureReading();
        tr.setTemperature(tr.getTemperature() + 1);
        clone.setTemperatureReading(tr);
        DepthReading dr = clone.getDepthReading();
        dr.setDepth(dr.getDepth() + 1);
        clone.setDepthReading(dr);
        assertEquals("temperature: 33.9, depth: 100.5", reading.toString());
        assertEquals("temperature: 34.9, depth: 101.5", clone.toString());
    }
}
