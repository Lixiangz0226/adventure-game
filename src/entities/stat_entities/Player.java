package entities.stat_entities;

import entities.stat_entities.Items.Item;
import entities.stat_entities.Monsters.Monster;
import entities.stat_entities.Skills.Charge;
import entities.stat_entities.Skills.Defend;
import entities.stat_entities.Skills.Double_Edge;
import entities.stat_entities.Skills.Skill;
import entities.stat_entities.Weapons.Knife;
import entities.stat_entities.Weapons.Weapon;
import entities.stat_entities.States.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends Character {
    /**
     * A Player is the controllable character for the user.
     *     A Player has a string name, int health, a list of State state_set,
     *     an inventory and a list of Skill skill_set.
      */

    private Inventory inventory = new Inventory();
    private List<Skill> skills = new ArrayList<>();
    private int money = 0;
    private int numKey = 0;
    private Weapon weapon = new Knife();
    private List<State> states = new ArrayList<>();
    public double dmgDealtRatio = 1;
    public double dmgReceivedRatio = 1;
    public Boolean piggyBankUsed = false;

    public Player(String name, int health) {
        /* Initializer */
        super(name, health);
        setMoney(100);
        skills.add(new Defend()); skills.add(new Double_Edge()); skills.add(new Charge());
    }

    public void addState(State state){/* Add a state */states.add(state);}

    private void countStates(){
        /* Counts all the states */
        dmgReceivedRatio = 1.0;
        dmgDealtRatio = 1.0;
        ArrayList<State> removing_states = new ArrayList<State>();
        for (State state : states) {

            String name = state.getName();
            if (Objects.equals(name, "Defensive")) {
                dmgReceivedRatio *= 0;}
            else if (Objects.equals(name, "Charging") && state.getRounds() == 0) {
                dmgDealtRatio *= 2;}
            else if (Objects.equals(name, "Piggy Banking")) {
                dmgDealtRatio *= (1 + (getMoney() * 0.01));}
            ///////////////////////////////////////////////////////////////////////////////////////////////////////State

            if (state.getRounds() == 0){removing_states.add(state);}
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
                monster.addState(new Burning());
            }dmg = weapon.getDamage();}
        else if (Objects.equals(name, "Defend")){
            addState(new Defensive());}
        else if (Objects.equals(name, "Double_Edge")){dmg += 30; dmg_received += 10;}
        else if (Objects.equals(name, "Charge")){
            addState(new Charging());}
        //////////////////////////////////////////////////////////////////////////////////////////////////////////skills
        //state damage multiplier
        countStates();
        dmg *= dmgDealtRatio;

        //flying bonus
        if (monster.getFlying() && weapon.flyingBonus()){dmg *= 1.5;}

        //weapon physical or magical type bonus
        if (weapon.physicalDamage()){dmg *= 1/monster.getPhysicalDef();}
        else{dmg *= 1/monster.getMagicalDef();}

        //Critical Check
        double randnum_crit = Math.random();
        if (randnum_crit < weapon.getCriticalRate()){dmg *= 1.5;}

        //Accuracy check
        double randnum_acc = Math.random();
        if (randnum_acc > weapon.getAccuracy()){dmg *= 0;}

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
                    addState(new PiggyBanking());
                    piggyBankUsed = true;
                }
            }

            ////////////////////////////////////////////////////////////////////////////////////////////consumable item
            return false;
        }
    }

    public Inventory getInventory() {/* Return the inventory */return inventory;}

    public void removeAllItems(){/* Remove all the items from the player */ inventory.removeAll();}

    public List<Skill> getSkills() {/* Return a copy of the list of skills */
        return new ArrayList<>(List.copyOf(skills));}

    public int getMoney() {/* Return money */return money;}

    public void setMoney(int money) {/* Set money */this.money = money;}

    public void add_key(){/* Add a key */numKey += 1;}

    public int getKey(){/* Return the number of keys */return numKey;}

    public void setKey(int num_key){/* Set the number of keys */this.numKey = num_key;}

    public void setWeapon(Weapon weapon){/* Set the weapon */this.weapon = weapon;}

    public String getWeaponName(){/* Return the weapon's name */return weapon.getName();}

    public Weapon getWeapon(){/* Return the weapon */return weapon;}

    public List<State> getStates(){/* Return a copy of states */return new ArrayList<>(List.copyOf(states));}

}
