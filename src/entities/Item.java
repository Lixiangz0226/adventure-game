package entities;

public class Item {

    public int health;
    /**
     * An Item with a unique use.
     */
    private String name;

    public Item (String name) {
        this.name = name;
    }

    public String get_name(){return this.name;}

}

class Life_Potion extends Item {
    public int health;

    public Life_Potion() {
        super("Life Potion");
        this.health = 20;
    }
}

class Golden_Key extends Item{
    public Golden_Key(){super("Golden key");}
}


