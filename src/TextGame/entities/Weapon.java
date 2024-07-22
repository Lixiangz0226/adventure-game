package TextGame.entities;

public class Weapon extends Item{
    /**
     * A weapon is an item that has different damage and can be equipped by player.
     */
    private int damage;

    public Weapon(String name, int damage){
        super(name);
        this.damage = damage;
    }

    public int get_damage(){return this.damage;}

}

class Flame_Crossbow extends Weapon{
    /*
    The weapon has a special effect that can add a burning state to the enemy.
     */

    //Private State effect;

    public Flame_Crossbow() {
        super("Flame crossbow", 10);
        //this.effect = new Burn();

    }
}

class Knife extends Weapon{
    /*
    The initial weapon of player.
     */
    public Knife(){super("Knife", 6);}
}
