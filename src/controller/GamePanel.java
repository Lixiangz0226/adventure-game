package controller;

import OutsideEntities.Monsters.Bat;
import OutsideEntities.Monsters.Goblin;
import OutsideEntities.Player;
import controller.EventController.*;
import entities.AbstractEntity;
import entities.PlayerController;
import Objects.AbstractObject;
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

    public final int maxMap = 10;
    public int currentMap = 0;


    int FPS = 60;

    //System Manager
    public TileManager tileA = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter setter = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);

    //UI
    public UI ui = new UI(this);

    //Entity and Object
    //Both object and entity are in an array of max 10 elements
    public PlayerController playerController = new PlayerController(this,keyH);
    public AbstractObject[][] obj = new AbstractObject[maxMap][10];
    public AbstractEntity[][] npc = new AbstractEntity[maxMap][10];
    public static Player player = new Player("Steve", 50);

    //Generate events
    public ShopEvent shop = new ShopEvent(player);
    public BattleEvent bat = new BattleEvent(player, new Bat());
    public BattleEvent goblin = new BattleEvent(player, new Goblin());
    public CursedFlowerEvent cursedFlower = new CursedFlowerEvent(player);
    public GuidingEvent guide = new GuidingEvent(player);
    public MysteryBoxEvent mystery = new MysteryBoxEvent(player);
    public QueenSlimeEvent slime = new QueenSlimeEvent(player);
    public SlotMachineEvent machine = new SlotMachineEvent(player);

    //Game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int eventState = 4;
    public final int shopState = 5;
    public final int battleState = 6;



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
        player.setMoney(999999999);
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
            playerController.update();
        }

        if(gameState == pauseState) {
            //nothing
        }

        if(gameState == playState) {
            for(int i = 0; i < npc[1].length; i++) {
                if(npc[currentMap][i] != null){
                    npc[currentMap][i].update();
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
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null) {
                    obj[currentMap][i].draw(g2, this);
                }
            }

            //Draw player
            playerController.draw(g2);

            //Draw each npc in the array
            for (int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null) {
                    npc[currentMap][i].draw(g2);

                }
            }

            //UI
            ui.draw(g2);

        }

        g2.dispose();

    }
}
