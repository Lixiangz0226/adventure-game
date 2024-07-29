package OutsideEntities.Weapons;

import OutsideEntities.Items.Item;

public class Weapon extends Item {
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

