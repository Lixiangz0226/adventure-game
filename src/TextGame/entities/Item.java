package TextGame.entities;

//Items that players can use in puzzles or battles
public class Item {

    //Item attributes
    public int health;
    private String name;

    //Item constructor
    public Item (String name) {
        this.name = name;
    }

    //Return the item name
    public String get_name(){return this.name;}
}

//Obtainable item classes in the game
class Life_Potion extends Item { public Life_Potion() {super("Life Potion");}}

class Golden_Key extends Item{ public Golden_Key(){super("Golden key");}}


