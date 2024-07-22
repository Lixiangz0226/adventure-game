package TextGame.entities;

public class Weapon extends Item{
    /**
     * Represents a weapon that can be used by characters in the game.
     * A weapon has a name and a certain amount of damage it can inflict.
     */
    private int damage;

    public Weapon(String name, int damage){
        super(name);
        this.damage = damage;
    }

    public int get_damage(){return this.damage;}

}

class Flame_Crossbow extends Weapon{
    private int damage;
    private String name;
    //private State effect;

    public Flame_Crossbow() {
        super("Flame crossbow", 10);
        //this.effect = new Burn();

    }
}

class Knife extends Weapon{

    public Knife(){super("Knife", 6);}
}
