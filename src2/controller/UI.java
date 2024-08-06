package controller;



import controller.Entity_Events.ShopEvent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public Boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public Boolean gameFinished = false;
    public String currentDialogue = "";
    Font minecraftFont;
    public int commandNumber = 0;


    //txt game merge
    //EventHandler eventHandler;
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;


    public UI(GamePanel gp) {
        this.gp = gp;
        //this.eventHandler = new EventHandler();

        try {
            InputStream is = getClass().getResourceAsStream("/resource/font/minecraft-font (1)/MinecraftRegular-Bmg3.otf");
            minecraftFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        gp.setFont(minecraftFont);
        g2.setColor(Color.white);

        //title state
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        //play state
        if (gp.gameState == gp.playState) {
        }

        //pause state
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }

        //dialogue state
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();

            }

        //shop state
        if (gp.gameState == gp.shopState) {
            System.out.println("shop active");
            drawShopWindow();
        }

        //battle state
        if (gp.gameState == gp.battleState) {
            System.out.println("battle active");
            drawGoblinWindow();
        }


    }

    private void drawTitleScreen() {

        //Title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
        String text = "ELDEN KEY";
        int x = getXForCenteredText(text);
        int y = gp.tileSize*3;

        //Title shadow
        g2.setColor(Color.GRAY);
        g2.drawString(text, x+5, y+5);

        //Main color
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        //Image
        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.playerController.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

        text = "NEW GAME";
        x = getXForCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
        if(commandNumber == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "LOAD GAME";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNumber == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "EXIT";
        x = getXForCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNumber == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }


    }

    private void drawDialogueScreen() {

        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);


        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);
    }

    private void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0,0,0, 180);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

    }

    private void drawShopWindow() {
        gp.shop.run_event();

        // Create a Swing Timer to check the shopOpened state periodically
        Timer timer = new Timer(100, e -> {
            if (!gp.shop.opened) {
                ((Timer) e.getSource()).stop(); // Stop the timer
                gp.shop.getWindow().setVisible(false);
            }
            else {
                gp.shop.getWindow().setVisible(true);
            }
        });
        timer.start(); // Start the timer

        gp.shop.opened = true;
        gp.gameState = gp.playState;
    }

    private void drawGoblinWindow() {
        gp.goblin.run_event();

        // Create a Swing Timer to check the shopOpened state periodically
        Timer timer = new Timer(100, e -> {
            if (!gp.goblin.opened) {
                ((Timer) e.getSource()).stop(); // Stop the timer
                gp.goblin.getWindow().setVisible(false);
            }
            else {
                gp.goblin.getWindow().setVisible(true);
            }
        });
        timer.start(); // Start the timer

        gp.goblin.opened = true;
        gp.gameState = gp.playState;
    }

   //private void initializeEventWindow(int x, int y, int width, int height) {
   //
   //    try {
   //        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
   //    } catch (Exception e) {
   //        e.printStackTrace();
   //    }
   //
   //    window = new JFrame();
   //    window.setBounds(x, y, width, height);
   //    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //    window.getContentPane().setBackground(Color.black);
   //    window.setLayout(null);
   //
   //    con = window.getContentPane();
   //
   //    JPanel mainTextPanel = new JPanel();
   //    mainTextPanel.setBounds(100, 100, 600, 250);
   //    mainTextPanel.setBackground(Color.black);
   //
   //    con.add(mainTextPanel);
   //    this.mainTextArea = new JTextArea("Fix this bug!");
   //    mainTextArea.setBounds(100, 100, 600, 250);
   //    mainTextArea.setBackground(Color.black);
   //    mainTextArea.setForeground(Color.white);
   //    mainTextArea.setFont(normalFont);
   //    mainTextArea.setLineWrap(true);
   //    mainTextArea.setWrapStyleWord(true);
   //    mainTextArea.setEditable(false);
   //
   //    mainTextPanel.add(mainTextArea);
   //
   //    window.setVisible(true);
   //
   //    test_battle0(con);
   //
   //}
   //
   //public void test_shop0(Container con) {
   //    PlayerController player = new PlayerController("Vergil", 100);
   //    player.setMoney(50);
   //    Battle_Event0 battle = new Battle_Event0(player, con, mainTextArea);
   //    battle.run_event();
   //
   //    // Create a Swing Timer to check the shopOpened state periodically
   //    Timer timer = new Timer(100, e -> {
   //        if (!shop.ShopOpened) {
   //            ((Timer) e.getSource()).stop(); // Stop the timer
   //            window.setVisible(false);
   //        }
   //        else {
   //            window.setVisible(true);
   //        }
   //    });
   //    timer.start(); // Start the timer
   //
   //    battle.BattleOpened = true;
   //    gp.gameState = gp.playState;
   //
   //}

    private void drawPauseScreen() {
        String text = "PAUSED";
        int x;

        x = getXForCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);

    }

    public int getXForCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }


}
