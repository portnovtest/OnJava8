package patterns.abstractfactory;

// An example of Abstract Factory pattern.
// {java patterns.abstractfactory.GameEnvironment}

import java.util.function.Supplier;

interface Obstacle {
    void action();
}

interface Player {
    void interactWith(Obstacle o);
}

class Kitty implements Player {

    @Override
    public void interactWith(Obstacle ob) {
        System.out.println("Kitty has encountered a ");
        ob.action();
    }
}

class Fighter implements Player {

    @Override
    public void interactWith(Obstacle ob) {
        System.out.println("Fighter now battles a ");
        ob.action();
    }
}

class Puzzle implements Obstacle {

    @Override
    public void action() {
        System.out.println("Puzzle");
    }
}

class Weapon implements Obstacle {

    @Override
    public void action() {
        System.out.println("Weapon");
    }
}

// The Abstract Factory:
class GameElementFactory {
    Supplier<Player> player;
    Supplier<Obstacle> obstacle;
}

// Concrete factories:
class KittiesAndPuzzles extends GameElementFactory {
    KittiesAndPuzzles() {
        player = Kitty::new;
        obstacle = Puzzle::new;
    }
}

class Melee extends GameElementFactory {
    Melee() {
        player = Fighter::new;
        obstacle = Weapon::new;
    }
}

public class GameEnvironment {
    private Player p;
    private Obstacle ob;

    GameEnvironment(GameElementFactory factory) {
        p = factory.player.get();
        ob = factory.obstacle.get();
    }

    public void play() {
        p.interactWith(ob);
    }

    public static void main(String[] args) {
        GameElementFactory kp = new KittiesAndPuzzles(),
                ml = new Melee();
        GameEnvironment g1 = new GameEnvironment(kp),
                g2 = new GameEnvironment(ml);
        g1.play();
        g2.play();
    }
}
