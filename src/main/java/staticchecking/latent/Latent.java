package staticchecking.latent;

// {java staticchecking.latent.Latent}

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Dog {
    public void talk() {
        System.out.println("Woof!");
    }

    public void reproduce() {

    }
}

class Robot {
    public void talk() {
        System.out.println("Click!");
    }

    public void oilChange() {

    }
}

class Mime {
    public void walkAgainstTheWind() {

    }

    @Override
    public String toString() {
        return "Mime";
    }
}

class Communicate {
    public static void speak(Object speaker) {
        try {
            Class<? extends Object> spkr = speaker.getClass();
            Method talk = spkr.getMethod("talk", (Class<?>[]) null);
            talk.invoke(speaker);
        } catch (NoSuchMethodException e) {
            System.out.println(speaker + " cannot talk");
        } catch (IllegalAccessException e) {
            System.out.println(speaker + " IllegalAccessException");
        } catch (InvocationTargetException e) {
            System.out.println(speaker + " InvocationTargetException");
        }
    }
}

public class Latent {
    public static void main(String[] args) {
        Communicate.speak(new Dog());
        Communicate.speak(new Robot());
        Communicate.speak(new Mime());
    }
}
