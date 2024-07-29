package entities;

import controller.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Guide extends AbstractEntity {


    public NPC_Guide(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getNPCImage();
    }

    //Load in npc sprite from the png files in resources
    public void getNPCImage () {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Back_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Front_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Front_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Lside_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Lside_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Rside_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/resource/NPC/NPC_Rside_2.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Similar to the player who acts based on keyboard inputs, the npc moves by recieving a direction input through
    //a random integer generator that gives each direction a 25%. The actionLockChecker allows a period of time
    //for each action to last instead of switching to a new direction and action every instance. The checker updates
    //every 120 ticks
    public void setAction() {

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
