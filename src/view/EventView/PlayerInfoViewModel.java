package view.EventView;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoViewModel extends EventViewModel{

    private JPanel backPanel;
    private JButton backButton;

    public PlayerInfoViewModel() {
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
    }

    public JButton getBackButton() {return backButton;}
}
