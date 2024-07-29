package OutsideEntities.Monsters;

import OutsideEntities.AbstractCharacter;
import OutsideEntities.States.State;

import java.util.ArrayList;
import java.util.List;

public class Monster extends AbstractCharacter {
    /**
     * A Monster is the enemy of players, which can suffer from
     *     different states. A Monster can't take any action if it's
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

