import java.awt.Color;
import java.awt.Container;

import java.swing.JFrame;

public class Game{
    JFrame window;
    Container con;

    public static void main(String[] args){
        new Game();
    }

    public Game(){

        window = new JFrame();
        window.setsize(1200,  900);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
    }
}

