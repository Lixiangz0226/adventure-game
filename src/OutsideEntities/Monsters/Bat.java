package OutsideEntities.Monsters;

import OutsideEntities.States.State;

import java.util.List;

public class Bat extends Monster{
    String name;
    int health;
    List<State> states;

    public Bat() {
        super("Bat", 20, 3, 1,1,true, 20);
        setMessage("The bat flew and bit you, dealt ");}
}