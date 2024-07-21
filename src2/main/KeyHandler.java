package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Senses when WASD keys are pressed are assign them to either up, down, left, and right
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = true;

        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;

        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;

        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;

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
