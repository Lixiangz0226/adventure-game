package TextGame.entities;

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

class Life_Potion extends Item {/* Recovers the player. */public Life_Potion() {super("Life Potion");}}

class Golden_Key extends Item{/* The key of defeating the boss. */public Golden_Key(){super("Golden key");}}


