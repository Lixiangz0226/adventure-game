package view.EventView;

import OutsideEntities.Monsters.*;
import OutsideEntities.Player;

import javax.swing.*;
import java.awt.*;

public class BossViewModel extends BattleViewModel{
    private JPanel weaponPanel;
    private JLabel weaponLabel;

    public BossViewModel(Player player, Monster monster) {
        super(player, monster);
        getChoice1().setActionCommand("c1ce");
        getChoice2().setActionCommand("c2ce");
        getChoice3().setActionCommand("c3ce");
        getChoice4().setActionCommand("c4ce");

        weaponPanel = new JPanel();
        weaponPanel.setBounds(200, 500, 400, 50);
        weaponPanel.setBackground(Color.black);
        con.add(weaponPanel);
        weaponLabel = new JLabel("Weapon: " + player.getWeaponName());
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponPanel.add(weaponLabel);
    }

    public JLabel getWeaponLabel(){return weaponLabel;}
}
