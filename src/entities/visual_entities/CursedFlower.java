package entities.visual_entities;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CursedFlower extends Entity {



    public BufferedImage sp1, sp2, sp3, sp4, sp5;
    private int spriteIndex = 1; // Start with the first sprite (sp1)



    public CursedFlower(GamePanel gp) {
        super(gp);

        direction = "sp1";
        speed = 0;
        isEnemy = true;
        name = "CursedFlower";

        setDialogue();
        getNPCImage();

    }

    //Load in npc sprite from the png files in resources
    public void getNPCImage () {
        try {
            sp1 = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Cursed_Flower/Cursed Flower-1.png"));
            sp2 = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Cursed_Flower/Cursed Flower-3.png"));
            sp3 = ImageIO.read(getClass().getResourceAsStream("/resource/objects/Cursed_Flower/Cursed Flower-2.png"));

            sp4 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedFlower/Happy Flower-4.png.png"));
            sp5 = ImageIO.read(getClass().getResourceAsStream("/resource/CursedFlower/Happy Flower-5.png.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {

        dialogues[0] = "SA...ve mE";
        dialogues[1] = "geT Me the...the";
        dialogues[2] = "...puRiFicATiOn pOwDEr";

    }

    //Similar to the player who acts based on keyboard inputs, the npc moves by recieving a direction input through
    //a random integer generator that gives each direction a 25%. The actionLockChecker allows a period of time
    //for each action to last instead of switching to a new direction and action every instance. The checker updates
    //every 120 ticks
    public void setAction() {
        actionLockCounter++;

        if (gp.cursedFlower.status) {
            if (actionLockCounter >= 15) { // Switch sprite every 120 ticks
                spriteIndex++; // Move to the next sprite
                if (spriteIndex > 3) {
                    spriteIndex = 1; // Reset to first sprite after the third one
                }

                switch (spriteIndex) {
                    case 1:
                        direction = "sp1";
                        break;
                    case 2:
                        direction = "sp2";
                        break;
                    case 3:
                        direction = "sp3";
                        break;
                }

                actionLockCounter = 0; // Reset the counter
            }
        } else {
            if (actionLockCounter >= 15) {
                if (direction.equals("sp4")) {
                    direction = "sp5";
                } else {
                    direction = "sp4";
                }
                actionLockCounter = 0;
            }
        }
    }



    public void speak() {

        if(gp.cursedFlower.status) {
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

    public void draw(Graphics2D g2) {

        BufferedImage image = sp1;

        switch (direction) {
            case "sp1":
                image = sp1;
                break;

            case "sp2":
                image = sp2;
                break;

            case "sp3":
                image = sp3;
                break;

            case "sp4":
                image = sp4;
                break;

            case "sp5":
                image = sp5;
                break;
        }


        g2.drawImage(image, x, y, gp.tileSize*2, gp.tileSize*2, null);

    }

}
