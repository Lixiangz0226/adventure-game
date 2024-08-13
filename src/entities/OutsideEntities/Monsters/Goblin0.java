package entities.OutsideEntities.Monsters;

import entities.OutsideEntities.States.State;

import java.util.List;

public class Goblin0 extends Monster{
    String name;
    int health;
    List<State> states;

    public Goblin0() {
        super("Goblin", 10, 1, 1,1,false, 20);
        setMessage("The goblin stabbed you with a knife, dealt ");}
}