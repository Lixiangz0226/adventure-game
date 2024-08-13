package OutsideEntities;

import OutsideEntities.Items.Item;
import OutsideEntities.Monsters.Monster;
import OutsideEntities.Skills.Charge;
import OutsideEntities.Skills.Defend;
import OutsideEntities.Skills.Double_Edge;
import OutsideEntities.Skills.Skill;
import OutsideEntities.States.*;
import OutsideEntities.Weapons.Knife;
import OutsideEntities.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends AbstractCharacter {
    /**
     * A Player is the controllable character for the user.
     *     A Player has a string name, int health, a list of State state_set,
     *     an inventory and a list of Skill skill_set.
      */

    private Inventory inventory = new Inventory();
    private List<Skill> skills = new ArrayList<>();
    private int money = 0;
    private int num_key = 0;
    private Weapon weapon = new Knife();
    private List<State> states = new ArrayList<>();
    public double dmgDealtRatio = 1;
    public double dmgReceivedRatio = 1;
    public Boolean piggyBankUsed = false;

    public Player(String name, int health) {
        /* Initializer */
        super(name, health);
        skills.add(new Defend()); skills.add(new Double_Edge()); skills.add(new Charge());
    }

    public void add_state(State state){/* Add a state */states.add(state);}

    private void count_effects(){
        /* Counts all the states */
        dmgReceivedRatio = 1.0;
        dmgDealtRatio = 1.0;
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getName();
            if (Objects.equals(name, "Defensive")) {
                dmgReceivedRatio *= 0;}
            else if (Objects.equals(name, "Charging") && state.getrounds() == 0) {
                dmgDealtRatio *= 2;}
            else if (Objects.equals(name, "Piggy Banking")) {
                dmgDealtRatio *= (1 + (getMoney() * 0.01));}
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
        double dmg = 0.0;
        double dmg_received = 0;

        if (Objects.equals(name, "Basic_Attack")){
            if (Objects.equals(getWeaponName(), "Flame Crossbow")){
                monster.add_state(new Burning());
            }dmg = weapon.get_damage();}
        else if (Objects.equals(name, "Defend")){add_state(new Defensive());}
        else if (Objects.equals(name, "Double_Edge")){dmg += 30; dmg_received += 10;}
        else if (Objects.equals(name, "Charge")){add_state(new Charging());}
        //////////////////////////////////////////////////////////////////////////////////////////////////////////skills
        //state damage multiplier
        count_effects();
        dmg *= dmgDealtRatio;

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

        dmg_received = (int)(dmgReceivedRatio * (monster.hit()) + dmg_received);
        setHealth(getHealth() - (int)dmg_received);
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
                inventory.removeItem(inventory.getItem(index));
            }
            else if (Objects.equals(inventory.getItem(index).getName(), "Piggy Bank")){
                if (!piggyBankUsed){
                    add_state(new PiggyBanking());
                    piggyBankUsed = true;
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////consumable item
            return false;
        }
    }

    public Inventory getInventory() {return inventory;}

    public List<Skill> getSkills() {return new ArrayList<>(List.copyOf(skills));}

    public int getMoney() {return money;}

    public void setMoney(int money) {this.money = money;}

    public void add_key(){num_key += 1;}

    public int getKey(){return num_key;}

    public void setKey(int num_key){this.num_key = num_key;}

    public void setWeapon(Weapon weapon){this.weapon = weapon;}

    public String getWeaponName(){return weapon.getName();}

    public Weapon getWeapon(){return weapon;}

    public List<State> getStates(){return new ArrayList<>(List.copyOf(states));}

}
