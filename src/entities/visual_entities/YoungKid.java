package entities.visual_entities;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class YoungKid extends Entity {


    public YoungKid(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 0;
        isEnemy = false;
        name = "YoungKid";

        setDialogue();
        getNPCImage();

    }

    //Load in npc sprite from the png files in resources
    public void getNPCImage () {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/Young_Kid.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {
        dialogues[0] = "Thank you for saving me!";
        dialogues[1] = "You should talk to my grandpa!";
        dialogues[2] = "AlSO! Press F to trigger events!";

    }


    //Similar to the player who acts based on keyboard inputs, the npc moves by recieving a direction input through
    //a random integer generator that gives each direction a 25%. The actionLockChecker allows a period of time
    //for each action to last instead of switching to a new direction and action every instance. The checker updates
    //every 120 ticks
    public void setAction() {

        if (gp.goblin.status == true && gp.gameState == gp.playState) {

            actionLockCounter++;

            if(actionLockCounter == 120) {
                Random random = new Random();
                int i = random.nextInt(100)+1;

                if(i <= 25) {
                    direction = "up";

                }

                if(i > 25 && i <= 50) {
                    direction = "down";

                }

                if(i > 50 && i <= 75) {
                    direction = "left";

                }

                if(i > 75 && i <= 100) {
                    direction = "right";

                }

                actionLockCounter = 0;
            }


        }

    }


    public void speak() {
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.playerController.direction) {
            case "up":
                direction = "down";
                break;

            case "down":
                direction = "up";
                break;

            case "left":
                direction = "right";
                break;

            case "right":
                direction = "left";
                break;


        }
    }



}
