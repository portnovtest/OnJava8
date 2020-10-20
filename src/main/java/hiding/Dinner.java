package hiding;

// Using the library

import hiding.dessert.Cookie;

public class Dinner {
    public static void main(String[] args) {
        Cookie x = new Cookie();
        //- x.bite(); // Can't access
    }
}
