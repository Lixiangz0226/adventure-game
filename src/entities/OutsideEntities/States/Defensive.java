package entities.OutsideEntities.States;

public class Defensive extends State {
    public Defensive(){
        super(2, "Defensive");
        setDescription("Defensive: Become immune to any damage for two rounds.\n");
    }
}
