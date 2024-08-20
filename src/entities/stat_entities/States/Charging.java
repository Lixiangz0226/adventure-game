package entities.stat_entities.States;

public class Charging extends State {
    /**
     * Doubles the damage dealt in the next round
     */
    public Charging(){
        super(1, "Charging");
        setDescription("Charging: Doubles the damage dealt in the next round.\n");
    }
}
