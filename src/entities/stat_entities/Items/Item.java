package entities.stat_entities.Items;

public abstract class Item {
    /**
     * Items that players can use in puzzles or battles
     */

    //Item attributes
    private String name;
    private String description = "";

    //Item constructor
    public Item (String name) {this.name = name;}

    //Return the item name
    public String getName(){return this.name;}

    public String getDescription(){return this.description;}

    public void setDescription(String description) {this.description = description;}
}


