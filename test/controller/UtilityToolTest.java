package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.image.BufferedImage;

class UtilityToolTest {

    @Test
    void scaleImage() {
        // Create a sample BufferedImage
        int originalWidth = 100;
        int originalHeight = 100;
        BufferedImage originalImage = new BufferedImage(originalWidth, originalHeight, BufferedImage.TYPE_INT_ARGB);

        // Fill the image with a solid color (optional)
        Graphics2D g2 = originalImage.createGraphics();
        g2.setColor(Color.RED);
        g2.fillRect(0, 0, originalWidth, originalHeight);
        g2.dispose();

        // Define the new width and height
        int newWidth = 50;
        int newHeight = 50;

        // Create an instance of UtilityTool
        UtilityTool utilityTool = new UtilityTool();

        // Call the scaleImage method
        BufferedImage scaledImage = utilityTool.scaleImage(originalImage, newWidth, newHeight);

        // Assertions
        assertNotNull(scaledImage, "The scaled image should not be null");
        assertEquals(newWidth, scaledImage.getWidth(), "The width of the scaled image should match the expected width");
        assertEquals(newHeight, scaledImage.getHeight(), "The height of the scaled image should match the expected height");
    }
}