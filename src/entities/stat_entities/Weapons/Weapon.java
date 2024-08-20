package entities.stat_entities.Weapons;

import entities.stat_entities.Items.Item;

public abstract class Weapon extends Item {
    /**
     * Represents a weapon that can be used by characters in the game.
     * A weapon has a name, damage, accuracy, and a critical rate.
     * Weapons can deal physical or magical damage
     * Some Weapons are effective against flying enemies
     */

    private int damage;
    private double accuracy;
    private double criticalRate;
    private double burnRate;
    private boolean physicalDamage;
    private boolean flyingBonus;
    private int sellValue;

    public Weapon(String name, int damage, double accuracy, double criticalRate, double burnRate,
                  boolean physicalDamage, boolean flyingBonus, int sellValue){//Constructor
        super(name);
        this.damage = damage;
        this.accuracy = accuracy;
        this.criticalRate = criticalRate;
        this.burnRate = burnRate;
        this.physicalDamage = physicalDamage;
        this.flyingBonus = flyingBonus;
        this.sellValue = sellValue;
    }

    public int getDamage(){/* Return the weapon damage */return this.damage;}

    public double getAccuracy(){/* Return accuracy */return this.accuracy;}

    public double getCriticalRate(){/* Return critical rate */return this.criticalRate;}

    public double getBurnRate(){/* Return burn rate */return this.burnRate;}

    public boolean physicalDamage(){/* Return physical damage */return this.physicalDamage;}

    public boolean flyingBonus(){/* Return flying bonus */return this.flyingBonus;}

    public int getSellValue(){/* Return sell value */return this.sellValue;}

}
