package entities.stat_entities.States;

public class Defensive extends State {
    /**
     * Become immune to any damage for two rounds.
     */
    public Defensive(){
        super(2, "Defensive");
        setDescription("Defensive: Become immune to any damage for two rounds.\n");
    }
}
