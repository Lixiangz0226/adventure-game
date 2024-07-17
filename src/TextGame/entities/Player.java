package TextGame.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Player extends Character {
    /**
     * A Player is the only controllable character for the user.
     *     A Player has a string name, an int health, a list of State state_set,
     *     an Inventory inventory and a list of Skill skill_set.
      */

    private Inventory inventory;
    private List<Skill> skills;
    private int money;
    private int num_key;
    private Weapon weapon;
    private List<State> states;
    private int dmg_dealt_ratio;
    private int dmg_received_ratio;
    Random rand = new Random();
    private Map map;

    public Player(String name, int health) {
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

    private void add_state(State state){states.add(state);}

    private void count_effects(){
        dmg_received_ratio = 1;
        dmg_dealt_ratio = 1;
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getdescription();
            if (Objects.equals(name, "Defensive")) {dmg_received_ratio *= 0;}
            else if (Objects.equals(name, "Charging") && state.getrounds() == 0) {dmg_dealt_ratio *= 2;}

            if (state.getrounds() == 0){removing_states.add(state);}
            else{state.count();}
        }
        for (State state : removing_states) {states.remove(state);}
    }

    public List<Integer> hit(Monster monster, Skill skill){
        ArrayList<Integer> result = new ArrayList<>();
        String name = skill.getName();
        int dmg = 0;
        int dmg_received = 0;

        if (Objects.equals(name, "Basic_Attack")){dmg = weapon.get_damage();}
        else if (Objects.equals(name, "Defend")){add_state(new Defensive());}
        else if (Objects.equals(name, "Double_Edge")){dmg += 30; dmg_received += 10;}
        else if (Objects.equals(name, "Charge")){add_state(new Charging());}

        count_effects();
        dmg *= dmg_dealt_ratio; dmg_received += dmg_received_ratio * (monster.getDamage() - 2 + rand.nextInt(5));
        setHealth(getHealth() - dmg_received);
        monster.setHealth(monster.getHealth() - dmg);
        result.add(dmg); result.add(dmg_received);
        return result;
    }

    public boolean use_item(int index){
        if (inventory.getItem(index) instanceof Weapon){
            Item pre_weapon = weapon;
            inventory.addItem(pre_weapon);
            weapon = (Weapon)inventory.getItem(index);
            inventory.removeItem(inventory.getItem(index));
            return true;
        }
        else{
            if (Objects.equals(inventory.getItem(index).get_name(), "Life Potion")){
                this.setHealth(this.getHealth() + 20);
            }
            inventory.removeItem(inventory.getItem(index));
            return false;
        }
    }

    public void add_map(Map map){this.map = map;}

    public void leave(){map.displayMap();}

    public Inventory getInventory() {return inventory;}

    public List<Skill> getSkills() {return skills;}

    public int getMoney() {return money;}

    public void setMoney(int money) {this.money = money;}

    public void add_key(){num_key += 1;}

    public int get_key(){return num_key;}
}
