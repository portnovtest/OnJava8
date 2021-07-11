package serialization;

// Restoring the state of the fictitious CAD system
// {RunFirst: AStoreCADState}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoveringCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/serialization/CADState.dat"))) {
            // Read in the same order they were written:
            List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
            Line.deserializeStaticState(in);
            List<Shape> shapes = (List<Shape>) in.readObject();
            System.out.println(shapes);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
