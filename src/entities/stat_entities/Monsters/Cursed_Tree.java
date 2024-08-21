package entities.stat_entities.Monsters;

import entities.stat_entities.States.State;

import java.util.Objects;

public class Cursed_Tree extends Monster{
    // The Cursed Tree Boss class
    private String message1 = "The Cursed Tree whipped you hard with its vines, dealt ";
    private String message2 = "The Cursed Tree binds your right arm with its roots, " +
            "making you unable to use items for 3 turns, dealt ";
    private String message3 = "The Cursed Tree raises a big branch over its head" +
            " and hits it hard at you, dealt ";
    private String message4 = "The Cursed Tree grows hundreds of razor-sharp leaves " +
            "and shoots them all at once, dealt ";
    private int randint = 0;

    public Cursed_Tree(){// Constructor
        super("The Cursed Tree", 1000, 10, 1.1, 0.9, false, 0);
    }

    @Override
    public Integer hit() {// Count the states and hit the player wrt randint.
        countStates();
        if (randint <= 3 && randint >= 0){return 10;}
        else if (randint == 4 || randint == 5){return 5;}
        else if (randint >= 6 && randint <= 8){return 15;}
        else{return 20;}
    }

    @Override
    public String getMessage() {// Return the string message wrt randint.
        if (randint <= 3 && randint >= 0){return message1;}
        else if (randint == 4 || randint == 5){return message2;}
        else if (randint >= 6 && randint <= 8){return message3;}
        else{return message4;}
    }

    @Override
    public void addState(State state){
        /* Add a state */
        for(State s : states){
            if (Objects.equals(s.getName(), state.getName())){
                s.renewRounds();
            }
        }
        states.add(state);
    }

    @Override
    public void countStates(){
        /* Counts all the states */
        super.countStates();
        for (State state : states) {
            String name = state.getName();
            if (Objects.equals(name, "Burning")) {setHealth(getHealth() - 10);}
        }
    }

    public void setRandint(int r){/* Set randint to be r */ randint = r;}
}
