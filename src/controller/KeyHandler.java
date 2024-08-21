package controller;

import entities.stat_entities.Player;
import data_access.LoadEvent;
import data_access.LoadPlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The KeyHandler class implements the KeyListener interface and handles all keyboard input
 * for the game, managing different states such as playing, pausing, shopping, and more.
 */

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, FPressed, loadPressed, IPressed;
    private LoadEvent loadEvent = new LoadEvent();
    private LoadPlayer loadPlayer = new LoadPlayer();

    GamePanel gp;
    Player player;

    /**
     * Constructor for the KeyHandler class.
     *
     * @param gp The GamePanel instance associated with this KeyHandler.
     */

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
        this.player = gp.player;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed. Handles the logic for different game states and key presses.
     *
     * @param e The KeyEvent containing the information about the key press.
     */

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
                //new game
                if(gp.ui.commandNumber == 0) {
                    try {
                        gp.newGame();
                        gp.gameState = gp.guideState;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                    //gp.gameState = gp.playState;

                }
                //load game
                if(gp.ui.commandNumber == 1) {
                    gp.gameState = gp.playState;
                    try {
                        loadPlayer.load(gp.player);
                        loadEvent.load(gp);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                if(gp.ui.commandNumber == 2) {
                    //quit game
                }

            }
        }

        //PLAY state
        if(gp.gameState == gp.playState) {

            if (gp.leftHanded == true) {

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
            }

            else {
                if (code == KeyEvent.VK_UP) {
                    upPressed = true;

                }
                if (code == KeyEvent.VK_DOWN) {
                    downPressed = true;

                }
                if (code == KeyEvent.VK_RIGHT) {
                    rightPressed = true;

                }

                if (code == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }

            }


            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            if (code == KeyEvent.VK_I) {
                gp.gameState = gp.infoState;
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

        //INFO state
        else if(gp.gameState == gp.infoState) {
            if (code == KeyEvent.VK_I) {
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

    /**
     * Invoked when a key has been released. Resets the direction keys when released.
     *
     * @param e The KeyEvent containing the information about the key release.
     */

    //When no WASD keys are held/pressed, no direction is assigned
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (gp.leftHanded == true) {

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
        else {

            if(code == KeyEvent.VK_UP) {
                upPressed = false;

            }
            if(code == KeyEvent.VK_DOWN) {
                downPressed = false;

            }
            if(code == KeyEvent.VK_RIGHT) {
                rightPressed = false;

            }
            if(code == KeyEvent.VK_LEFT) {
                leftPressed = false;

            }

        }


    }
}
