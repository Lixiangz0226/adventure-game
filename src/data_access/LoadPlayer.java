package data_access;

import entities.stat_entities.Items.Life_Potion;
import entities.stat_entities.Items.PiggyBank;
import entities.stat_entities.Items.PurificationPotion;
import entities.stat_entities.Player;
import entities.stat_entities.Weapons.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;


public class LoadPlayer{
    /**
     * The loader of player info.
     * It Returns a player with the saved info in
     * src\data_access\Player.txt
     */

    File myObj = new File("src\\data_access\\Player.txt");


    public void load(Player player) throws FileNotFoundException {
        // Load the player's info from the file saved
        if (!myObj.exists()) {return;}
        Scanner myReader = new Scanner(myObj);
        // name
        player.setName(myReader.nextLine());
        // HP
        player.setHealth(Integer.parseInt(myReader.nextLine()));
        // Keys
        player.setKey(Integer.parseInt(myReader.nextLine()));
        // Money
        player.setMoney(Integer.parseInt(myReader.nextLine()));
        // Weapon
        weaponHelper(myReader.nextLine(), player);
        // Inventory
        player.removeAllItems();
        inventoryHelper(myReader.nextLine(), player);

        myReader.close();
    }

    private void weaponHelper(String name, Player player){
        // Set the player's weapon to the saved player's weapon
        if (Objects.equals(name, "Battle Axe")){player.setWeapon(new Battle_Axe());}
        else if (Objects.equals(name, "Flame Crossbow")){player.setWeapon(new Flame_Crossbow());}
        else if (Objects.equals(name, "Katana")) {player.setWeapon(new Katana());}
        else if (Objects.equals(name, "Spear")) {player.setWeapon(new Spear());}
        else if (Objects.equals(name, "Staff")) {player.setWeapon(new Staff());}
    }

    private void inventoryHelper(String items, Player player){
        // Add items to the player
        for (String item : items.split(",")) {
            if (Objects.equals(item, "Battle Axe")) {
                player.getInventory().addItem(new Battle_Axe());
            } else if (Objects.equals(item, "Flame Crossbow")) {
                player.getInventory().addItem(new Flame_Crossbow());
            } else if (Objects.equals(item, "Katana")) {
                player.getInventory().addItem(new Katana());
            } else if (Objects.equals(item, "Spear")) {
                player.getInventory().addItem(new Spear());
            } else if (Objects.equals(item, "Staff")) {
                player.getInventory().addItem(new Staff());
            } else if (Objects.equals(item, "Life Potion")) {
                player.getInventory().addItem(new Life_Potion());
            } else if (Objects.equals(item, "Piggy Bank")) {
                player.getInventory().addItem(new PiggyBank());
            } else if (Objects.equals(item, "Purification Potion")) {
                player.getInventory().addItem(new PurificationPotion());
            }
        }
    }
}
