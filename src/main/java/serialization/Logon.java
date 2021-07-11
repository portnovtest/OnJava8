package serialization;

// Demonstrates the "transient" keyword

import onjava.Nap;

import java.io.*;
import java.util.Date;

public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "logon info: \n    username: " + username + "\n    date: " + date + "\n    password: " + password;
    }

    public static void main(String[] args) {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("src/main/java/serialization/Logon.dat"))) {
            o.writeObject(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Nap(1);
        // Now get them back:
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/serialization/Logon.dat"))) {
            System.out.println("Recovering object at " + new Date());
            a = (Logon) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logon a = " + a);
    }
}
