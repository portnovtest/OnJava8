package javadoc;

import java.util.Date;

/**
 * The first On Java 8 example program.
 * Displays a String and today's date.
 *
 * @author Joe Blow
 * @version 5.0
 */
public class HelloDateDoc {
    /**
     * Entry point to class & application.
     *
     * @param args array of String arguments
     * @throws exceptions No exceptions thrown
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
    }
}
