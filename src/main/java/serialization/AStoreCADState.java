package serialization;

// Saving the state of a fictitious CAD system

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum Color {RED, BLUE, GREEN}

abstract class Shape implements Serializable {
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(Color newColor);

    public abstract Color getColor();

    Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    @Override
    public String toString() {
        return getClass() + "Color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {
    private static Color color = Color.RED;

    Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

class Square extends Shape {
    private static Color color = Color.RED;

    Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

class Line extends Shape {
    private static Color color = Color.RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeObject(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException, ClassNotFoundException {
        color = (Color) os.readObject();
    }

    Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

public class AStoreCADState {
    public static void main(String[] args) {
        List<Class<? extends Shape>> shapeTypes = Arrays.asList(Circle.class, Square.class, Line.class);
        List<Shape> shapes = IntStream.range(0, 10)
                .mapToObj(i -> Shape.randomFactory())
                .collect(Collectors.toList());
        // Set all the static colors to GREEN:
        shapes.forEach(s -> s.setColor(Color.GREEN));
        // Save the state vector:
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/java/serialization/CADState.dat"))) {
            out.writeObject(shapeTypes);
            Line.serializeStaticState(out);
            out.writeObject(shapes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Display the shapes:
        System.out.println(shapes);
    }
}
