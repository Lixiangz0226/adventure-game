package OutsideEntities.Items;

//Items that players can use in puzzles or battles
public class Item {

    //Item attributes
    private String name;
    private String description;

    //Item constructor
    public Item (String name) {
        this.name = name;
        this.description = description;
    }

    //Return the item name
    public String getName(){return this.name;}

    public String getDescription(){return this.description;}

    public void setDescription(String description) {this.description = description;}
}


