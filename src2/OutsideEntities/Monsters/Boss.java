package OutsideEntities.Monsters;

import OutsideEntities.States.*;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Monster{

    private List<State> states;


    public Boss(String name, int health, int damage, double physical_def, double magical_def, boolean flying, int gold_drop) {
        super(name, health, damage, physical_def, magical_def, flying, gold_drop);
        this.states = new ArrayList<State>();
    }

    private void add_state(State state){/* Add a state */states.add(state);}

    private void count_effects(){
        /* Counts all the states */
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getName();

            ///////////////////////////////////////////////////////////////////////////////////////////////////////State

            if (state.getrounds() == 0){removing_states.add(state);}
            else{state.count();}
        }
        for (State state : removing_states) {states.remove(state);}
    }

}
