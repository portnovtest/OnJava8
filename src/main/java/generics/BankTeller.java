package generics;

// A very simple bank teller simulation

import onjava.Suppliers;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Customer " + id;
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Teller " + id;
    }
}

class Bank {
    private List<BankTeller> tellers = new ArrayList<>();

    public void put(BankTeller bt) {
        tellers.add(bt);
    }
}

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        // Demonstrate create():
        RandomList<Teller> tellers = Suppliers.create(RandomList::new, Teller::new, 4);
        // Demonstrate fill():
        List<Customer> customers = Suppliers.fill(new ArrayList<>(), Customer::new, 12);
        customers.forEach(c -> serve(tellers.select(), c));
        // Demonstrate assisted latent typing:
        Bank bank = Suppliers.fill(new Bank(), Bank::put, BankTeller::new, 3);
        // Can also use second version of fill():
        List<Customer> customers2 = Suppliers.fill(new ArrayList<>(), List::add, Customer::new, 12);
    }
}
