package OutsideEntities.Items;

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
    public String getName(){return this.name;}
}


