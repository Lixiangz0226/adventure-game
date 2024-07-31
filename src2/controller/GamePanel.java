package controller;

import entities.AbstractEntity;
import entities.Player;
import use_case.AbstractObject;
import view.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Attributes declare
    final int originalTilesSize = 16;
    final int scale = 3;

    //Note the maxScreenCow/Row represents the number of tiles displayed on screen
    public final int tileSize = originalTilesSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    //System Manager
    public TileManager tileA = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter setter = new AssetSetter(this);

    //UI
    public UI ui = new UI(this);

    //Entity and Object
    //Both object and entity are in an array of max 10 elements
    public Player player = new Player(this,keyH);
    public AbstractObject[] obj = new AbstractObject[10];
    public AbstractEntity[] npc = new AbstractEntity[10];

    //Game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int shopState = 4;


    //Constructor method
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {
        setter.setObject();
        setter.setNPC();
        gameState = titleState;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread != null) {

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    //update each element of the list of entities(npc) as well as the player entity
    public void update() {

        if(gameState == playState) {
            player.update();
        }

        if(gameState == pauseState) {
            //nothing
        }

        if(gameState == playState) {
            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null){
                    npc[i].update();
        }
            }
        }

        if(gameState == shopState) {
            //pause game
            //set J panel to ve visible
            //call eventHandler

        }

    }

    //Draw each component of the game in the order of tile > object > player > NPC
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(gameState == titleState) {
            ui.draw(g2);

        }
        else {
            tileA.draw(g2);

            //Draw each object in the array
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            //Draw player
            player.draw(g2);

            //Draw each npc in the array
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].draw(g2);

                }
            }

            //UI
            ui.draw(g2);

        }

        g2.dispose();

    }
}
