package UseCaseInteracter;

import entities.OutsideEntities.Items.Item;
import entities.OutsideEntities.Skills.Skill;
import entities.OutsideEntities.States.State;
import entities.Player;
import Presenter.PlayerInfoPresenter;

import javax.swing.*;
import java.util.ArrayList;

public class PlayerInfoInteracter {
    private PlayerInfoPresenter presenter;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int index = 0;
    private ArrayList<Skill> skills;
    private ArrayList<State> states;

    public PlayerInfoInteracter(Player player, JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                JButton choice4) {
        presenter = new PlayerInfoPresenter(mainTextArea, choice1, choice2, choice3, choice4);
        inventory.addAll(player.getInventory().getItems());
        inventory.add(player.getWeapon());
        skills = (ArrayList) player.getSkills();
        states = (ArrayList) player.getStates();
    }

    public String start(){
        presenter.start();
        return "start";
    }

    public String inventory(){
        index = 0;
        presenter.describe((index + 1) + ". " + inventory.get(index).getDescription());
        return "inventory";
    }

    public String upInv(){
        if (index <= 0){
            return "inventory";
        }
        index -= 1;
        presenter.describe((index + 1) + ". " + inventory.get(index).getDescription());
        return "inventory";
    }

    public String downInv(){
        if (index >= inventory.size() - 1){
            return "inventory";
        }
        index += 1;
        presenter.describe((index + 1) + ". " + inventory.get(index).getDescription());
        return "inventory";
    }

    public String skills(){
        index = 0;
        presenter.describe((index + 1) + ". " + skills.get(index).getDescription());
        return "skills";
    }

    public String upSkill(){
        if (index <= 0){
            return "skills";
        }
        index -= 1;
        presenter.describe((index + 1) + ". " + skills.get(index).getDescription());
        return "skills";
    }

    public String downSkill(){
        if (index >= skills.size() - 1){
            return "skills";
        }
        index += 1;
        presenter.describe((index + 1) + ". " + skills.get(index).getDescription());
        return "skills";
    }

    public String states(){
        if (states.isEmpty()){
            presenter.describe("-");
            return "states";
        }
        index = 0;
        presenter.describe((index + 1) + ". " + states.get(index).getDescription());
        return "states";
    }

    public String upState(){
        if (states.isEmpty()){
            presenter.describe("-");
            return "states";
        }
        if (index <= 0){
            return "states";
        }
        index -= 1;
        presenter.describe((index + 1) + ". " + states.get(index).getDescription());
        return "states";
    }

    public String downState(){
        if (states.isEmpty()){
            presenter.describe("-");
            return "states";
        }
        if (index >= states.size() - 1){
            return "states";
        }
        index += 1;
        presenter.describe((index + 1) + ". " + states.get(index).getDescription());
        return "states";
    }
}
