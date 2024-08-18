package view.EventView;

import javax.swing.*;
import java.awt.*;

public abstract class EventViewModel {
    /**
     * The abstract class of view model of events
     */
    JFrame window;
    Container con;
    JTextArea mainTextArea;
    JButton choice1; JButton choice2; JButton choice3; JButton choice4;
    JPanel choiceButtonPanel;

    Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);

    public EventViewModel() {
        // Constructor
        try {
            UIManager UIManager = null;
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        window = new JFrame();
        window.setBounds(370, 100, 800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        JPanel mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);

        con.add(mainTextPanel);
        mainTextArea = new JTextArea("Fix this bug!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        window.setVisible(false);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.setActionCommand("c1se");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.setActionCommand("c2se");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.setActionCommand("c3se");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.setActionCommand("c4se");
        choiceButtonPanel.add(choice4);


    }

    public JTextArea getMainTextArea() {/* Return the mainTextArea */return mainTextArea;}

    public JButton getChoice1() {/* Return the choice1 */return choice1;}

    public JButton getChoice2() {/* Return the choice2 */return choice2;}

    public JButton getChoice3() {/* Return the choice3 */return choice3;}

    public JButton getChoice4() {/* Return the choice4 */return choice4;}

    public Container getCon(){/* Return the con */return con;}

    public Window getWindow(){/* Return the window */return window;}
}
