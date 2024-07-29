package controller;


import Event_Tester_Package.Test_Event;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public Boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public Boolean gameFinished = false;
    public String currentDialogue = "";

    //txt game merge
    EventHandler eventHandler;


    public UI(GamePanel gp) {
        this.gp = gp;
        this.eventHandler = new EventHandler();

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        gp.setFont(arial_80B);
        g2.setColor(Color.white);

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
            drawShopWindow();
        }

    }

    private void drawDialogueScreen() {

        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);
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
        System.out.println("made it 2");
        eventHandler.openShopEvent();
    }

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
