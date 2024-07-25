package TextGame.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Monster extends Character {
    /**
     * A Monster is the enemy of players, which can suffer from
     *     different states. A Monster can't take any action if it's
     *     health <= 0.
     */
    Random rand = new Random();


    private List<State> states;
    private int damage;
    private String message;

    public Monster(String name, int health, int damage) {
        super(name, health);
        this.states = new ArrayList<State>();
        this.damage = damage;
        message = "";
    }

    public int getDamage() {return this.damage;}

    public String getMessage() {return this.message;}

    public void setMessage(String message){this.message = message;}

    public Integer hit() {return getDamage() - 2 + rand.nextInt(5);}
}

class Goblin extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin() {
        super("Goblin", 24, 6);
        setMessage("The goblin stabbed you with a knife, dealt ");}
}
