package OutsideEntities.States;

public class Charging extends State {
    public Charging(){
        super(1, "Charging");
        setDescription("Charging: Doubles the damage dealt in next round.\n");
    }
}
