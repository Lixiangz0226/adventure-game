package view.EventView;

import entities.stat_entities.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoViewModel extends EventViewModel{
    /**
     * The view model of Player info page
     */
    private JLabel money;
    private JPanel playerPanel; JLabel hpLabelNumber;
    private JPanel backPanel;
    private JButton backButton;
    private JPanel homePanel;
    private JButton homeButton;
    private JPanel handSwitchPanel;
    private JButton handSwitchButton;

    public PlayerInfoViewModel(Player player) {// Constructor


        super();

        getChoice1().setActionCommand("c1");
        getChoice2().setActionCommand("c2");
        getChoice3().setActionCommand("c3");
        getChoice4().setActionCommand("c4");

        backPanel = new JPanel();
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
        backPanel.setVisible(true);

        homePanel = new JPanel();
        homePanel.setBounds(550, 500, 200, 50);
        homePanel.setBackground(Color.black);
        homeButton = new JButton("Main Menu");
        homeButton.setBackground(Color.black);
        homeButton.setForeground(Color.white);
        homeButton.setFont(normalFont);
        homeButton.setFocusPainted(false);
        homeButton.setActionCommand("c6");
        homePanel.add(homeButton);
        con.add(homePanel);
        homePanel.setVisible(true);

        this.playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        JLabel hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        this.hpLabelNumber = new JLabel(player.getHealth() + "");
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        JLabel moneyLabel = new JLabel("Money:");
        moneyLabel.setFont(normalFont);
        moneyLabel.setForeground(Color.white);
        moneyLabel.setBackground(Color.red);
        playerPanel.add(moneyLabel);
        this.money = new JLabel("" + player.getMoney());
        money.setFont(normalFont);
        money.setForeground(Color.white);
        playerPanel.add(money);

        handSwitchPanel = new JPanel();
        handSwitchPanel.setBounds(300, 500, 200, 50);
        handSwitchPanel.setBackground(Color.black);
        handSwitchButton = new JButton("Switch Hand");
        handSwitchButton.setBackground(Color.black);
        handSwitchButton.setForeground(Color.white);
        handSwitchButton.setFont(normalFont);
        handSwitchButton.setFocusPainted(false);
        handSwitchButton.setActionCommand("c7");
        handSwitchPanel.add(handSwitchButton);
        con.add(handSwitchPanel);
        handSwitchPanel.setVisible(true);



    }

    public JButton getHandSwitchButton (){/* Return the handSwitchButton */ return handSwitchButton; }

    public JButton getBackButton() {/* Return the backButton */return backButton;}

    public JLabel getHpLabelNumber() {/* Return the hpLabelNumber */return hpLabelNumber;}

    public JButton getHomeButton(){/* Return home Button */return homeButton;}

    public JLabel getMoney(){/* Return the money label */return money;}
}
