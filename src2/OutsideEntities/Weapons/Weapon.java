package OutsideEntities.Weapons;

import OutsideEntities.Items.Item;

public class Weapon extends Item {
    /**
     * Represents a weapon that can be used by characters in the game.
     * A weapon has a name, damage, accuracy, and a critical rate.
     * Weapons can deal physical or magical damage
     * Some Weapons are effective against flying enemies
     */

    private int damage;
    private double accuracy;
    private double critical_rate;
    private double burn_rate;
    private boolean physical_damage;
    private boolean flying_bonus;
    private int sell_value;

    public Weapon(String name, int damage, double accuracy, double critical_rate,double burn_rate,
                  boolean physical_damage, boolean flying_bonus, int sell_value){
        super(name);
        this.damage = damage;
        this.accuracy = accuracy;
        this.critical_rate = critical_rate;
        this.burn_rate = burn_rate;
        this.physical_damage = physical_damage;
        this.flying_bonus = flying_bonus;
        this.sell_value = sell_value;
    }

    public int get_damage(){return this.damage;}

    public double get_accuracy(){return this.accuracy;}

    public double get_critical_rate(){return this.critical_rate;}

    public double get_burn_rate(){return this.burn_rate;}

    public boolean physical_damage(){return this.physical_damage;}

    public boolean flying_bonus(){return this.flying_bonus;}

    public int get_sell_value(){return this.sell_value;}

}
