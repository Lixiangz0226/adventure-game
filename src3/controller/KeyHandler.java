package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, eventTrigger, shopTrigger;

    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Senses when WASD keys are pressed are assign them to either up, down, left, and right
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;

        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;

        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;

        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;

        }
        if (code == KeyEvent.VK_ENTER) {
            eventTrigger = true;

        }

        if (code == KeyEvent.VK_F) {
            System.out.println("shopTrigger is true");
            shopTrigger = true;


        }

        if (code == KeyEvent.VK_P) {
            if (gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }

        }


    }

    //When no WASD keys are held/pressed, no direction is assigned
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;

        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;

        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;

        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;

        }



    }
}
