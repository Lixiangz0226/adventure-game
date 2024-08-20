package entities.stat_entities.Items;

public class PiggyBank extends Item {
    /**
     * The special item that can be used in a battle and gives a special state to the player that
     * scales the money of player into damage.
     */
    public PiggyBank(){
        super("Piggy Bank");
        setDescription("Piggy Bank: When being used in the battle, the more money comes the more damage dealing.\n");
    }
}
