package entities.visual_entities;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Bat3 extends Entity {


    public Bat3(GamePanel gp) {
        super(gp);

        direction = "right";
        speed = 3;

        isEnemy = true;
        name = "Bat3";

        setDialogue();
        getNPCImage();

    }

    //Load in npc sprite from the png files in resources
    public void getNPCImage () {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Back_1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Back_2.png.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Front_1.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Front_2.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Left_1.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Left_2.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Right_1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Bat_Right_2.png.png"));

            death = ImageIO.read(getClass().getResourceAsStream("/resource/Bat/Dead_Bat.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {
        dialogues[0] = "WRRRYYYY";
        dialogues[1] = "KYAAAA";


    }


    //Similar to the player who acts based on keyboard inputs, the npc moves by recieving a direction input through
    //a random integer generator that gives each direction a 25%. The actionLockChecker allows a period of time
    //for each action to last instead of switching to a new direction and action every instance. The checker updates
    //every 120 ticks
    public void setAction() {
        if (gp.bat3.status) {

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
        else {
            direction = "dead";
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
