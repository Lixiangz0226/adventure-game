package app;

import controller.GamePanel;

import javax.swing.*;

public class Main2 {
    public static void main(String[] args) {

        //Create game window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Elden Keys");

        GamePanel gamePanel = new  GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();



    }

}
