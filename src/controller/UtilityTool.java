package controller;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The UtilityTool class provides utility methods for image processing and manipulation.
 */

public class UtilityTool {

    /**
     * Scales a given BufferedImage to the specified width and height.
     *
     * @param original The original BufferedImage to be scaled.
     * @param width    The desired width of the scaled image.
     * @param height   The desired height of the scaled image.
     * @return A new BufferedImage object that is the scaled version of the original image.
     */

    public BufferedImage scaleImage(BufferedImage original, int width, int height) {

        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();

        return scaledImage;

    }
}
