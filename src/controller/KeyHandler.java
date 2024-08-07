package controller;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, FPressed;

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

        //TITLE state
        if(gp.gameState == gp.titleState) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNumber--;
                if(gp.ui.commandNumber < 0) {
                    gp.ui.commandNumber = 2;
                }

            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNumber++;
                if(gp.ui.commandNumber > 2) {
                    gp.ui.commandNumber = 0;
                }
            }

            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNumber == 0) {
                    gp.gameState = gp.playState;

                }
                if(gp.ui.commandNumber == 1) {
                    //load game
                }

                if(gp.ui.commandNumber == 2) {
                    //quit game
                }

            }
        }

        //PLAY state
        if(gp.gameState == gp.playState) {

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
                enterPressed = true;
            }

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }

        }

        //DIALOGUE state
        else if(gp.gameState == gp.dialogueState) {

            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }

            if (code == KeyEvent.VK_F) {
                FPressed = true;
                System.out.println("F key detected during dialogue state");
                // Manually call interactNPC if necessary
                int npcIndex = gp.cChecker.checkEntity(gp.playerController, gp.npc);
                gp.playerController.interactNPC(npcIndex);
            }

        }

        //SHOP state
        else if(gp.gameState == gp.shopState) {
            if (code == KeyEvent.VK_F) {
                gp.gameState = gp.playState;
            }
        }

        //Battle state
        else if(gp.gameState == gp.battleState) {
            if (code == KeyEvent.VK_F) {
                gp.gameState = gp.playState;
            }
        }


        //PAUSE state
        else if(gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
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
