package TextGame.entities.Weapons;

import TextGame.entities.Items.Item;

public class Weapon extends Item {
    /**
     * Represents a weapon that can be used by characters in the game.
     * A weapon has a name, damage, accuracy, and a critical rate.
     * Weapons can deal physical or magical damage
     * Some Weapons are effective against flying enemies
     */

    private int damage;
    private float accuracy;
    private float critical_rate;
    private boolean physical_damage;
    private boolean flying_bonus;

    public Weapon(String name, int damage, float accuracy){
        super(name);
        this.damage = damage;
        this.accuracy = accuracy;
        this.critical_rate = critical_rate;
        this.physical_damage = true;
        this.flying_bonus = false;
    }

    public int get_damage(){return this.damage;}

    public float get_accuracy(){return this.accuracy;}

    public float get_critical_rate(){return this.critical_rate;}

    public boolean check_physical_damage(){return this.physical_damage;}

    public boolean check_flying_bonus(){return this.flying_bonus;}

}

