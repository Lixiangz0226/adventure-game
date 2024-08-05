package OutsideEntities.States;

public class Burning extends State {
    public Burning(){
        super(3, "Burning");
        setDescription("Burning: Looses 10 HP every rounds.\n");
    }
}
