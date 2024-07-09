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
    private int damage;

    public Monster(String name, int health, int damage) {
        super(name, health);
        this.states = new ArrayList<State>();
        this.damage = damage;
    }

    public int getDamage() {return this.damage;}
}

class Goblin extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin() {
        super("Goblin", 24, 6);

    }
}
