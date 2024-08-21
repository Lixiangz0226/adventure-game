package use_case_interacter;

import entities.stat_entities.Items.Item;
import entities.stat_entities.Skills.Skill;
import entities.stat_entities.States.State;
import entities.stat_entities.Player;
import presenter.PlayerInfoPresenter;

import javax.swing.*;
import java.util.ArrayList;

public class PlayerInfoInteracter extends EventInteracter{
    /**
     * The use case interacter of Player info page
     */
    private PlayerInfoPresenter presenter;
    private ArrayList<Item> inventory;
    private int index = 0;
    private ArrayList<Skill> skills;
    private ArrayList<State> states;
    private Player player;

    public PlayerInfoInteracter(Player player, JTextArea mainTextArea, JButton choice1, JButton choice2, JButton choice3,
                                JButton choice4, JLabel hp, JLabel money) {// Constructor
        presenter = new PlayerInfoPresenter(mainTextArea, choice1, choice2, choice3, choice4, hp, money, player);
        this.player = player;
    }

    public String start(){// The start use case
        inventory = new ArrayList<Item>();
        inventory.addAll(player.getInventory().getItems());
        inventory.add(player.getWeapon());
        presenter.start();
        skills = (ArrayList) player.getSkills();
        states = (ArrayList) player.getStates();
        return "start";
    }

    public String inventory(){// The inventory use case
        index = 0;
        presenter.describe((index + 1) + ". " + inventory.get(index).getDescription());
        return "inventory";
    }

    public String upInv(){// The use case rolling up the inventory
        if (index <= 0){
            return "inventory";
        }
        index -= 1;
        presenter.describe((index + 1) + ". " + inventory.get(index).getDescription());
        return "inventory";
    }

    public String downInv(){// The use case rolling down the inventory
        if (index >= inventory.size() - 1){
            return "inventory";
        }
        index += 1;
        presenter.describe((index + 1) + ". " + inventory.get(index).getDescription());
        return "inventory";
    }

    public String skills(){// The Skills use case
        index = 0;
        presenter.describe((index + 1) + ". " + skills.get(index).getDescription());
        return "skills";
    }

    public String upSkill(){// The use case rolling up the skill set
        if (index <= 0){
            return "skills";
        }
        index -= 1;
        presenter.describe((index + 1) + ". " + skills.get(index).getDescription());
        return "skills";
    }

    public String downSkill(){// The use case rolling down the skill set
        if (index >= skills.size() - 1){
            return "skills";
        }
        index += 1;
        presenter.describe((index + 1) + ". " + skills.get(index).getDescription());
        return "skills";
    }

    public String states(){// The states use case
        if (states.isEmpty()){
            presenter.describe("-");
            return "states";
        }
        index = 0;
        presenter.describe((index + 1) + ". " + states.get(index).getDescription());
        return "states";
    }

    public String upState(){// The use case rolling up the state list
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

    public String downState(){// The use case rolling down the state list
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
