package reflection;

// Using isInstance()


import onjava.Pair;
import reflection.pets.Pet;
import reflection.pets.PetCreator;

import java.util.HashMap;
import java.util.stream.Collectors;

public class PetCounter3 {
    static class Counter extends HashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(PetCreator.ALL_TYPES.stream()
                    .map(type -> Pair.make(type, 0))
                    .collect(Collectors.toMap(Pair::key, Pair::value)));
        }

        public void count(Pet pet) {
            // Class.isInstance() eliminates instanceofs:
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet))
                    .forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s", pair.getKey().getSimpleName(), pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{" + result + "}";
        }
    }

    public static void main(String[] args) {
        Counter petCount = new Counter();
        new PetCreator().stream()
                .limit(20)
                .peek(petCount::count)
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));
        System.out.println("\n" + petCount);
    }
}
