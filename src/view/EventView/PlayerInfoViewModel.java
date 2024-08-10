package view.EventView;

import OutsideEntities.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoViewModel extends EventViewModel{

    private JLabel money;
    private JPanel playerPanel; JLabel hpLabelNumber;
    private JPanel backPanel;
    private JButton backButton;

    public PlayerInfoViewModel(Player player) {
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
    }

    public JButton getBackButton() {return backButton;}

    public JLabel getHpLabelNumber() {return hpLabelNumber;}

    public JLabel getMoneyLabel() {return money;}
}
