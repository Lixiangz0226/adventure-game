package entities;

public class Item {

    /**
     * An Item with a unique use.
     */
    private String name;

    public Item (String name) {
        this.name = name;
    }

    public String get_name(){return this.name;}

}

class Flame_Crossbow extends Item{
    private int damage;
    private String name;
    //private State effect;

    public Flame_Crossbow() {
        super("Flame crossbow");
        this.damage = 10;
        //this.effect = new Burn();

    }
    public int get_damage(){return this.damage;}
}

class Life_Potion extends Item{
    private int health;

    public Life_Potion(){
        super("Life Potion");
        this.health = 10;
    }

class Key extends Item{
        public Key(){super("Key");}
}
}

