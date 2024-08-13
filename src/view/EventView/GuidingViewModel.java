package view.EventView;

import entities.OutsideEntities.Monsters.Monster;
import entities.Player;

import javax.swing.*;
import java.awt.*;

public class GuidingViewModel extends ShopViewModel{

    private JPanel playerPanel;
    private JLabel hpLabelNumber;
    private JLabel enemyhp;
    private JPanel backPanel;
    JButton backButton;

    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);


    Container con;

    public GuidingViewModel(Player player, Monster monster) {
        super();
        con = getCon();
        getChoice1().setActionCommand("c1be");
        getChoice2().setActionCommand("c2be");
        getChoice3().setActionCommand("c3be");
        getChoice4().setActionCommand("c4be");

        this.playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        JLabel hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        this.hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        hpLabelNumber.setText("" + player.getHealth());
        playerPanel.add(hpLabelNumber);
        JLabel enemylabel = new JLabel(monster.getName() + " HP:");
        enemylabel.setFont(normalFont);
        enemylabel.setForeground(Color.white);
        enemylabel.setBackground(Color.red);
        playerPanel.add(enemylabel);
        this.enemyhp = new JLabel();
        enemyhp.setFont(normalFont);
        enemyhp.setForeground(Color.white);
        enemyhp.setText("" + monster.getHealth());
        playerPanel.add(enemyhp);

        this.backPanel = new JPanel();
        backPanel.setBounds(100, 500, 100, 50);
        backPanel.setBackground(Color.black);
        backButton = new JButton("Back");
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFont(normalFont);
        backButton.setFocusPainted(false);
        backButton.setActionCommand("c5");
        backPanel.add(backButton);
        con.add(backPanel);
        backPanel.setVisible(false);
    }

    public JButton getBackButton() {return backButton;}

    public JLabel getHpLabelNumber(){return hpLabelNumber;}

    public JLabel getEnemyhp(){return enemyhp;}

    public JPanel getBackPanel(){return backPanel;}

    public JPanel getPlayerPanel(){return playerPanel;}
}
