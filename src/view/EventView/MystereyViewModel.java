package view.EventView;

import javax.swing.*;
import java.awt.*;

public class MystereyViewModel extends EventViewModel{
    /**
     * The view model of mystery box event
     */
    private JPanel playerPanel;
    private JLabel hpLabelNumber;
    private JLabel moneyNumber;


    public MystereyViewModel() {// Constructor
        super();
        getChoice1().setActionCommand("c1mb");
        getChoice2().setActionCommand("c2mb");
        getChoice3().setActionCommand("c3mb");
        getChoice4().setActionCommand("c4mb");

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
        hpLabelNumber.setText("");
        playerPanel.add(hpLabelNumber);
        JLabel gold = new JLabel("Gold: ");
        gold.setFont(normalFont);
        gold.setForeground(Color.white);
        gold.setBackground(Color.red);
        playerPanel.add(gold);
        this.moneyNumber = new JLabel();
        moneyNumber.setFont(normalFont);
        moneyNumber.setForeground(Color.white);
        moneyNumber.setText("");
        playerPanel.add(moneyNumber);
    }

    public JLabel getHpLabelNumber() {/* Return the hpLabelNumber */return hpLabelNumber;}

    public JLabel getMoneyNumber() {/* Return the moneyNumber */return moneyNumber;}
}
