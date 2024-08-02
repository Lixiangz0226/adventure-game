package OutsideEntities;

import OutsideEntities.Items.*;
import OutsideEntities.Weapons.*;
import OutsideEntities.Monsters.*;
import OutsideEntities.Skills.*;
import OutsideEntities.States.*;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends AbstractCharacter {
    /**
     * A Player is the controllable character for the user.
     *     A Player has a string name, int health, a list of State state_set,
     *     an inventory and a list of Skill skill_set.
      */

    private Inventory inventory;
    private List<Skill> skills;
    private int money;
    private int num_key;
    private Weapon weapon;
    private List<State> states;
    private int dmg_dealt_ratio;
    private int dmg_received_ratio;
    private Map map;

    public Player(String name, int health) {
        /* Initializer */
        super(name, health);
        this.inventory = new Inventory();
        this.skills = new ArrayList<>();
        skills.add(new Defend()); skills.add(new Double_Edge()); skills.add(new Charge());
        this.money = 0;
        this.states = new ArrayList<>();
        this.num_key = 0;
        this.weapon = new Knife();
        this.dmg_dealt_ratio = 1;
        this.dmg_received_ratio = 1;
        this.map = null;
    }

    public void add_state(State state){/* Add a state */states.add(state);}

    private void count_effects(){
        /* Counts all the states */
        dmg_received_ratio = 1;
        dmg_dealt_ratio = 1;
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getdescription();
            if (Objects.equals(name, "Defensive")) {dmg_received_ratio *= 0;}
            else if (Objects.equals(name, "Charging") && state.getrounds() == 0) {dmg_dealt_ratio *= 2;}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////State

            if (state.getrounds() == 0){removing_states.add(state);}
            else{state.count();}
        }
        for (State state : removing_states) {states.remove(state);}
    }

    public List<String> hit(Monster monster, Skill skill){
        /* Player hits the monster using the skill */
        ArrayList<String> result = new ArrayList<>();
        String name = skill.getName();
        double dmg = 0;
        int dmg_received = 0;

        if (Objects.equals(name, "Basic_Attack")){dmg = weapon.get_damage();}
        else if (Objects.equals(name, "Defend")){add_state(new Defensive());}
        else if (Objects.equals(name, "Double_Edge")){dmg += 30; dmg_received += 10;}
        else if (Objects.equals(name, "Charge")){add_state(new Charging());}
        //////////////////////////////////////////////////////////////////////////////////////////////////////////skills
        //state damage multiplier
        count_effects();
        dmg *= dmg_dealt_ratio;

        //flying bonus
        if (monster.getFlying() && weapon.flying_bonus()){dmg *= 1.5;}

        //weapon physical or magical type bonus
        if (weapon.physical_damage()){dmg *= 1/monster.getPhysicalDef();}
        else{dmg *= 1/monster.getMagicalDef();}

        //Critical Check
        double randnum_crit = Math.random();
        if (randnum_crit < weapon.get_critical_rate()){dmg *= 1.5;}

        //Accuracy check
        double randnum_acc = Math.random();
        if (randnum_acc > weapon.get_accuracy()){dmg *= 0;}

        dmg_received += dmg_received_ratio * (monster.hit());
        setHealth(getHealth() - dmg_received);
        monster.setHealth(monster.getHealth() - (int)dmg);
        result.add("You used " + skill.getName() + " and dealt " + (int)dmg + " damage.");
        result.add(monster.getMessage() + dmg_received + " damage.");
        return result;
    }

    public boolean use_item(int index){
        /* the player either uses the consumable item or equips equipment at the index of the inventory.*/
        if (inventory.getItem(index) instanceof Weapon){
            Item pre_weapon = weapon;
            inventory.addItem(pre_weapon);
            weapon = (Weapon)inventory.getItem(index);
            inventory.removeItem(inventory.getItem(index));
            return true;
        }
        else{
            if (Objects.equals(inventory.getItem(index).getName(), "Life Potion")){
                this.setHealth(this.getHealth() + 20);
            }

            ////////////////////////////////////////////////////////////////////////////////////////////consumable item

            inventory.removeItem(inventory.getItem(index));
            return false;
        }
    }

    public void add_map(Map map){/* Gives the player the map currently in */this.map = map;}

    public void leave(){/* The Player leaves the event and goes back to the map */map.displayMap();}

    public Inventory getInventory() {return inventory;}

    public List<Skill> getSkills() {return skills;}

    public int getMoney() {return money;}

    public void setMoney(int money) {this.money = money;}

    public void add_key(){num_key += 1;}

    public int get_key(){return num_key;}

    public String getWeaponName(){return weapon.getName();}
}