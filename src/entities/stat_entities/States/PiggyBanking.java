package entities.stat_entities.States;

public class PiggyBanking extends State {
    /**
     * The more money the player owns, the more damage dealing.
     */
    public PiggyBanking() {
        super(999, "Piggy Banking");
        setDescription("Piggy Banking: The more money the player owns, the more damage dealing.");
    }
}
