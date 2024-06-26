import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game{

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    public static void main(String[] args) {
        new Game();
    }

    public Game(){

        window = new JFrame();
        window.setSize(1200, 900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        //window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURER");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        newButtonPanel = new JPanel();
        newButtonPanel.setBounds(300, 400, 200, 100);
        newButtonPanel.setBackground(Color.black);

        newButton = new JButton("NEW");
        newButton.setBackground(Color.black);
        newButton.setForeground(Color.white);
        newButton.setFont(normalFont);
        newButton.setFocusPainted(false);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(300, 500, 200, 100);
        loadButtonPanel.setBackground(Color.black);

        loadButton = new JButton("LOAD");
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.setFont(normalFont);
        loadButton.FocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        newButtonPanel.add(newButton);
        loadButtonPanel.add(loadButton);

        con.add(titleNamePanel);
        con.add(newButtonPanel);
        con.add(loadButtonPanel);

        window.setVisible(true);
    }
}
