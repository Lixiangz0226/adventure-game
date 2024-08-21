package app;

import controller.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Main class to launch the Elden Keys game.
 * Sets up the game window and initializes the GamePanel.
 */

public class Main2 {
    JButton homeButton;
    JPanel homePanel;
    static Container con;

    /**
     * Entry point of the application. Sets up the game window and starts the game.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws IOException If there is an error initializing game resources.
     */

    public static void main(String[] args) throws IOException {

        //Create game window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Elden Keys");

        // Create and add the GamePanel to the window
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        // Set up the window size and visibility
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Initialize and start the game
        gamePanel.setUpGame();
        gamePanel.startGameThread();



    }

}
