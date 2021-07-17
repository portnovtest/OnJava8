package staticchecking.petspeak;

// Speaking pets in Java
// {java staticchecking.petspeak.PetSpeak}

interface Pet {
    void speak();
}

class Cat implements Pet {

    @Override
    public void speak() {
        System.out.println("meow!");
    }
}

class Dog implements Pet {

    @Override
    public void speak() {
        System.out.println("woof!");
    }
}

public class PetSpeak {
    static void command(Pet p) {
        p.speak();
    }

    public static void main(String[] args) {
        Pet[] pets = {new Cat(), new Dog()};
        for (Pet pet : pets) {
            command(pet);
        }
    }

}
