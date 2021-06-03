package patterns;

import patterns.shapes.BadShapeCreation;
import patterns.shapes.FactoryMethod;
import patterns.shapes.FactoryTest;
import patterns.shapes.Shape;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory2 implements FactoryMethod {
    private Map<String, Constructor<?>> factories = new HashMap<>();

    private static Constructor<?> load(String id) {
        System.out.println("loading " + id);
        try {
            return Class.forName("patterns.shapes." + id).getConstructor();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new BadShapeCreation(id);
        }
    }

    @Override
    public Shape create(String id) {
        try {
            return (Shape) factories.computeIfAbsent(id, ShapeFactory2::load).newInstance();
        } catch (Exception e) {
            throw new BadShapeCreation(id);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactory2());
    }
}
