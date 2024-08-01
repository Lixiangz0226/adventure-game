package OutsideEntities.Monsters;

import OutsideEntities.States.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Boss extends Monster{

    private List<State> states;


    public Boss(String name, int health, int damage) {
        super(name, health, damage);
        this.states = new ArrayList<State>();
    }

    private void add_state(State state){/* Add a state */states.add(state);}

    private void count_effects(){
        /* Counts all the states */
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getdescription();

            ///////////////////////////////////////////////////////////////////////////////////////////////////////State

            if (state.getrounds() == 0){removing_states.add(state);}
            else{state.count();}
        }
        for (State state : removing_states) {states.remove(state);}
    }

}
