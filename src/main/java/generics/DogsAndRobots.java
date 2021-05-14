package generics;

import reflection.pets.Dog;

// No (direct) latent typing in Java

class PerformingDog extends Dog implements Performs {

    @Override
    public void speak() {
        System.out.println("Woof!");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class Robot implements Performs {

    @Override
    public void speak() {
        System.out.println("Click!");
    }

    @Override
    public void sit() {
        System.out.println("Clank!");
    }

    public void oilChange() {
    }
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        Communicate.perform(new PerformingDog());
        Communicate.perform(new Robot());
    }
}
