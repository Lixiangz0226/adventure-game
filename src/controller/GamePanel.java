package controller;

import entities.stat_entities.Monsters.Bat;
import entities.stat_entities.Monsters.Goblin;
import entities.stat_entities.Player;
import controller.EventController.*;
import data_access.LoadPlayer;
import data_access.SavePlayer;
import entities.map_objects.Object;
import entities.visual_entities.Entity;
import view.TileViewManager;
import presenter.MapPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The GamePanel class is the main panel for the game, responsible for rendering the game world,
 * managing game states, and handling the game loop. It extends JPanel and implements Runnable
 * to support multi-threading for smooth gameplay.
 */

public class GamePanel extends JPanel implements Runnable{

    //Attributes declare
    final int originalTilesSize = 16;
    final int scale = 3;
    SavePlayer savePlayer;

    //Note the maxScreenCow/Row represents the number of tiles displayed on screen
    public int tileSize = originalTilesSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxMap = 10;
    public int currentMap = 0;

    public boolean leftHanded = true;



    int FPS = 60;

    //System Manager
    public TileViewManager tileA = new TileViewManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter setter = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);
    public static LoadPlayer playerLoader = new LoadPlayer();

    //UI
    public MapPresenter ui = new MapPresenter(this);

    //Entity and Object
    //Both object and entity are in an array of max 10 elements
    public PlayerController playerController = new PlayerController(this,keyH);
    public Object[][] obj = new Object[maxMap][20];
    public Entity[][] npc = new Entity[maxMap][20];

    //add if statement to inject saved player
    public Player player = new Player("Steve", 50);


    //Generate events
    public ShopEvent shop = new ShopEvent(player);
    public BattleEvent bat1 = new BattleEvent(player, new Bat(), this);
    public BattleEvent bat2 = new BattleEvent(player, new Bat(), this);
    public BattleEvent bat3 = new BattleEvent(player, new Bat(), this);
    public BattleEvent goblin = new BattleEvent(player, new Goblin(), this);
    public CursedFlowerEvent cursedFlower = new CursedFlowerEvent(player);
    public CursedTreeEvent cursedTree = new CursedTreeEvent(player, this);
    public GuidingEvent guide = new GuidingEvent(player);
    public MysteryBoxEvent mystery = new MysteryBoxEvent(player);
    public QueenSlimeEvent slime = new QueenSlimeEvent(player);
    public SlotMachineEvent machine = new SlotMachineEvent(player);
    public PlayerInfo playInfo = new PlayerInfo(player, this);

    //Game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    //public final int eventState = 4;
    public final int shopState = 5;
    public final int battleState = 6;
    public final int bossState = 7;
    public final int bat1State = 8;
    public final int bat2State = 9;
    public final int bat3State = 10;
    public final int infoState = 11;
    public final int flowerState = 12;
    public final int guideState = 13;
    public final int slotState = 14;
    public final int boxState = 15;

    /**
     * Constructs the GamePanel, initializing the panel's properties and setting up
     * input handling and background color.
     *
     * @throws IOException if there is an error initializing game resources.
     */

    //Constructor method
    public GamePanel() throws IOException {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    /**
     * Initializes a new game, resetting all events, entities, and player data.
     *
     * @throws IOException if there is an error resetting game resources.
     */

    // Make everything new
    public void newGame() throws IOException {
        player = new Player("Steve", 50);
        shop = new ShopEvent(player);
        bat1 = new BattleEvent(player, new Bat(), this);
        bat2 = new BattleEvent(player, new Bat(), this);
        bat3 = new BattleEvent(player, new Bat(), this);
        goblin = new BattleEvent(player, new Goblin(), this);
        cursedFlower = new CursedFlowerEvent(player);
        cursedTree = new CursedTreeEvent(player, this);
        guide = new GuidingEvent(player);
        mystery = new MysteryBoxEvent(player);
        slime = new QueenSlimeEvent(player);
        machine = new SlotMachineEvent(player);
        playInfo = new PlayerInfo(player, this);
    }

    /**
     * Sets up the game by initializing objects, NPCs, and setting the game state
     * to the title screen.
     */

    public void setUpGame() {
        setter.setObject();
        setter.setNPC();
        gameState = titleState;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * The main game loop, responsible for updating game logic and rendering the game screen
     * at a consistent frame rate.
     */

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

    /**
     * Updates the game state and entities based on the current game state.
     * Handles player and NPC updates during gameplay.
     */

    //update each element of the list of entities(npc) as well as the player entity
    public void update() {

        if(gameState == playState) {
            playerController.update();
        }

        if(gameState == pauseState) {
            //nothing
        }

        if(gameState == playState && !goblin.fighting && !bat1.fighting && !bat2.fighting && !bat3.fighting && !shop.shopping && !guide.fighting) {
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

        if(gameState == battleState) {
            //nothing
        }


    }

    /**
     * Draws the game components in the correct order: tiles, objects, player, NPCs, and UI.
     *
     * @param g The Graphics object used for drawing.
     */

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


            //Draw each npc in the array
            for (int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null) {
                    npc[currentMap][i].draw(g2);

                }
            }

            //Draw player
            playerController.draw(g2);

            //UI
            ui.draw(g2);

        }

        g2.dispose();

    }

    public KeyHandler getKeyH() {
        return keyH;
    }
}
