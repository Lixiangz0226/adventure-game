package OutsideEntities.Monsters;

import OutsideEntities.States.State;

import java.util.ArrayList;
import java.util.Objects;

public class Cursed_Tree extends Boss{

    private ArrayList<State> states = new ArrayList<>();
    private String message1 = "The Cursed Tree whipped you hard with the vines, dealt ";
    private String message2 = "The Cursed Tree binds your right arm with its roots, " +
            "making you unable to use items for 3 turns, dealt";
    private String message3 = "The Cursed Tree raises a big branch over its head," +
            " and then hits it hard at you, dealt ";
    private String message4 = "The Cursed Tree's branches grow hundreds of razor-sharp gray leaves " +
            "in a very short period of time, and then shoot at you at once, dealt ";
    private int randint = 0;

    public Cursed_Tree(){
        super("The Cursed Tree", 1000, 10, 1.1, 0.9, false, 0);
    }

    @Override
    public Integer hit() {
        count_effects();
        if (randint <= 3 && randint >= 0){return 10;}
        else if (randint == 4 || randint == 5){return 5;}
        else if (randint >= 6 && randint <= 8){return 15;}
        else{return 20;}
    }

    public String getMessage() {
        if (randint <= 3 && randint >= 0){return message1;}
        else if (randint == 4 || randint == 5){return message2;}
        else if (randint >= 6 && randint <= 8){return message3;}
        else{return message4;}
    }

    public void add_state(State state){
        /* Add a state */
        for(State s : states){
            if (Objects.equals(s.getdescription(), state.getdescription())){
                s.renewRounds();
            }
        }
        states.add(state);
    }

    private void count_effects(){
        /* Counts all the states */
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getdescription();
            if (Objects.equals(name, "Burning")) {setHealth(getHealth() - 20);}

            if (state.getrounds() == 0){removing_states.add(state);}
            else{state.count();}
        }
        for (State state : removing_states) {states.remove(state);}
    }

    public void setRandint(int r){randint = r;}
}
