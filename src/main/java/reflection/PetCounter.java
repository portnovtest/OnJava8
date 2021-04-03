package reflection;

import reflection.pets.*;

import java.util.HashMap;

public class PetCounter {
    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    private Counter counter = new Counter();

    private void countPet(Pet pet) {
        System.out.print(pet.getClass().getSimpleName() + " ");
        if (pet instanceof Pet) {
            counter.count("Pet");
        }
        if (pet instanceof Dog) {
            counter.count("Dog");
        }
        if (pet instanceof Mutt) {
            counter.count("Mutt");
        }
        if (pet instanceof Pug) {
            counter.count("Pug");
        }
        if (pet instanceof Cat) {
            counter.count("Cat");
        }
        if (pet instanceof EgyptianMau) {
            counter.count("EgyptianMau");
        }
        if (pet instanceof Manx) {
            counter.count("Manx");
        }
        if (pet instanceof Cymric) {
            counter.count("Cymric");
        }
        if (pet instanceof Rodent) {
            counter.count("Rodent");
        }
        if (pet instanceof Rat) {
            counter.count("Rat");
        }
        if (pet instanceof Mouse) {
            counter.count("Mouse");
        }
        if (pet instanceof Hamster) {
            counter.count("Hamster");
        }
    }

    public void count(Creator creator) {
        creator.stream()
                .limit(20)
                .forEach(this::countPet);
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new PetCounter().count(new ForNamePetCreator());
    }
}
