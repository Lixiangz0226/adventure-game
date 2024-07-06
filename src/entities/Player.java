package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<List<Effect>> effects;
    private int dmg_dealt_ratio;
    private int dmg_received_ratio;

    public Player(String name, int health) {
        super(name, health);
        this.inventory = new Inventory();
        this.skills = new ArrayList<>();
        skills.add(new Defend()); skills.add(new Double_Edge()); skills.add(new Charge());
        this.money = 0;
        this.states = new ArrayList<>();
        this.num_key = 0;
        this.weapon = new Knife();
        this.effects = new ArrayList<>();
        for (int i = 0; i < 10; i++){effects.add(new ArrayList<>());}
        this.dmg_dealt_ratio = 1;
        this.dmg_received_ratio = 1;
    }

    private void count_effects(){
        List<Effect> lst= effects.get(0);
        for (int i = 0; i < lst.size(); i++){
            //
        }
        effects.removeFirst(); effects.add(new ArrayList<Effect>());
    }

    public List<Integer> hit(Monster monster, Skill skill){
        ArrayList<Integer> result = new ArrayList<>();
        count_effects();
        String name = skill.getName();
        int dmg = 0;
        if (Objects.equals(name, "Basic_Attack")){
            dmg = weapon.get_damage() * dmg_dealt_ratio;
        }
        else if (Objects.equals(name, "Defend")){
            //
        }
        else if (Objects.equals(name, "Double_Edge")){
            //
        }
        else if (Objects.equals(name, "Charge")){
            //
        }
        else{
            //
        }

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
                setHealth(getHealth() + inventory.getItem(index).health);
            }
            inventory.removeItem(inventory.getItem(index));
            return false;
        }
    }
    public Inventory getInventory() {return inventory;}

    public List<Skill> getSkills() {return skills;}

    public int getMoney() {return money;}

    public void setMoney(int money) {this.money = money;}

    public void add_key(){num_key += 1;}

    public int get_key(){return num_key;}
}
