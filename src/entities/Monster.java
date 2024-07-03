package entities;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Character {
    /**
     * A Monster is the enemy of players, which can suffer from
     *     different states. A Monster can't take any action if  it's
     *     health <= 0.
     */


    private List<State> states;

    public Monster(String name, int health) {
        super(name, health);
        this.states = new ArrayList<State>();
    }
}

class Goblin extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin() {
        super("Goblin", 24);

    }
}
