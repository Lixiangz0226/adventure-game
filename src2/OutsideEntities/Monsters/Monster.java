package OutsideEntities.Monsters;

import OutsideEntities.AbstractCharacter;
import OutsideEntities.States.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Monster extends AbstractCharacter {
    /**
     * A Monster is the enemy of players, which can suffer from
     *     different states. A Monster can't take any action if it's
     *     health <= 0.
     */
    Random rand = new Random();


    private List<State> states;
    private int damage;
    private String message;
    private float physical_def;
    private float magical_def;
    private boolean flying;
    private int gold_drop;


    public Monster(String name, int health, int damage, float physical_def, float magical_def, boolean flying, int gold_drop) {
        super(name, health);
        this.states = new ArrayList<State>();
        this.damage = damage;
        this.physical_def = physical_def;
        this.magical_def = magical_def;
        this.flying = flying;
        this.gold_drop = gold_drop;
        message = "";
    }

    public int getDamage() {return this.damage;}

    public float getPhysicalDef() {return this.physical_def;}

    public float getMagicalDef() {return this.magical_def;}

    public boolean getFlying() {return this.flying;}

    public int getGoldDrop() {return this.gold_drop;}

    public String getMessage() {return this.message;}

    public void setMessage(String message){this.message = message;}

    public Integer hit() {return getDamage() - 2 + rand.nextInt(5);}
}

