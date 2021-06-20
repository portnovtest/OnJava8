package equalshashcode;

import collections.MapOfList;
import reflection.pets.Individual;
import reflection.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IndividualTest {
    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values()) {
            for (Pet p : lp) {
                pets.add(p);
            }
        }
        pets.forEach(System.out::println);
    }
}
