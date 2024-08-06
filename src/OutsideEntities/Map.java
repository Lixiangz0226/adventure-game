package OutsideEntities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.Objects;

//The map creates and connects multiple rooms that branch out from the starting room
//The map uses buttons and panels to display directions and let players move north, south, east, and west
//The map indicates whether it's daytime or nighttime
public class Map{

    //Map attributes
    private boolean day;
    private Room startRoom;
    private Room playerRoom;
    private JButton c1, c2, c3, c4;
    private JTextArea mainTextArea;
    private Container con;
    private Player player;
    private JPanel choiceButtonPanel;
    private JTextArea locationTextArea;
    MapHandler mapHandler  = new MapHandler();
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    String info;

    public Map(Container con, Room startRoom, Player player, JTextArea mainTextArea){

        this.mainTextArea = mainTextArea;

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        JButton c1 = new JButton("Choice 1");
        c1.setBackground(Color.black);
        c1.setForeground(Color.white);
        c1.setFont(normalFont);
        c1.setFocusPainted(false);
        c1.addActionListener(mapHandler);
        c1.setActionCommand("c1m");
        choiceButtonPanel.add(c1);
        JButton c2 = new JButton("Choice 2");
        c2.setBackground(Color.black);
        c2.setForeground(Color.white);
        c2.setFont(normalFont);
        c2.setFocusPainted(false);
        c2.addActionListener(mapHandler);
        c2.setActionCommand("c2m");
        choiceButtonPanel.add(c2);
        JButton c3 = new JButton("Choice 3");
        c3.setBackground(Color.black);
        c3.setForeground(Color.white);
        c3.setFont(normalFont);
        c3.setFocusPainted(false);
        c3.addActionListener(mapHandler);
        c3.setActionCommand("c3m");
        choiceButtonPanel.add(c3);
        JButton c4 = new JButton("Choice 4");
        c4.setBackground(Color.black);
        c4.setForeground(Color.white);
        c4.setFont(normalFont);
        c4.setFocusPainted(false);
        c4.addActionListener(mapHandler);
        c4.setActionCommand("c4m");
        choiceButtonPanel.add(c4);
        this.c1 = c1;this.c2 = c2;this.c3 = c3;this.c4 = c4;
        this.day = true;
        this.con = con;
        this.startRoom = startRoom;
        this.playerRoom = startRoom;
        this.player = player;

        JPanel locationPanel = new JPanel();
        locationPanel.setBounds(600, 450, 200, 100);
        locationPanel.setBackground(Color.black);
        locationTextArea = new JTextArea(playerRoom.getName());
        locationTextArea.setBackground(Color.black);
        locationTextArea.setForeground(Color.white);
        locationTextArea.setFont(normalFont);
        locationPanel.add(locationTextArea);
        con.add(locationPanel);
        locationPanel.setVisible(true);
        locationTextArea.setLineWrap(true);
        locationTextArea.setWrapStyleWord(true);
        locationTextArea.setEditable(false);

        choiceButtonPanel.setVisible(false);

    }

    public boolean getDay () {return day;}

    public void changeDay () {this.day = !this.day;}

    public void displayMap () {
        choiceButtonPanel.setVisible(true);
        choose();
    }

    public Room get_playerroom(){return playerRoom;}

    private void choose(){
        info = "";
        if (playerRoom.getN() == null){info += "North: Dead End\n";}
        else {info += "North: "+playerRoom.getN().getName()+"\n";}
        if (playerRoom.getS() == null){info += "South: Dead End\n";}
        else {info += "South: "+playerRoom.getS().getName()+"\n";}
        if (playerRoom.getW() == null){info += "West: Dead End\n";}
        else {info += "West: "+playerRoom.getW().getName()+"\n";}
        if (playerRoom.getE() == null){info += "East: Dead End";}
        else {info += "East: "+playerRoom.getE().getName();}
        mainTextArea.setText(info);
        c1.setText("-"); if (playerRoom.getN() != null){c1.setText("Go North");}
        c2.setText("-"); if (playerRoom.getS() != null){c2.setText("Go South");}
        c3.setText("-"); if (playerRoom.getW() != null){c3.setText("Go West");}
        c4.setText("-"); if (playerRoom.getE() != null){c4.setText("Go East");}
    }

    public class MapHandler implements ActionListener{
        /*This handles the action of moving around the map*/
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "c1m":
                    if (Objects.equals(c1.getText(), "-")){break;}
                    else{ playerRoom = playerRoom.getN();
                        locationTextArea.setText(playerRoom.getName());
                        choiceButtonPanel.setVisible(false);
                        playerRoom.run_room();break;
                    }
                case "c2m":
                    if (Objects.equals(c2.getText(), "-")){break;}
                    else{ playerRoom = playerRoom.getS();
                        locationTextArea.setText(playerRoom.getName());
                        choiceButtonPanel.setVisible(false);
                        playerRoom.run_room();break;}
                case "c3m":
                    if (Objects.equals(c3.getText(), "-")){break;}
                    else{ playerRoom = playerRoom.getW();
                        locationTextArea.setText(playerRoom.getName());
                        choiceButtonPanel.setVisible(false);
                        playerRoom.run_room();break;}
                case "c4m":
                    if (Objects.equals(c4.getText(), "-")){break;}
                    else{ playerRoom = playerRoom.getE();
                        locationTextArea.setText(playerRoom.getName());
                        choiceButtonPanel.setVisible(false);
                        playerRoom.run_room();break;}
            }
        }
    }

}



