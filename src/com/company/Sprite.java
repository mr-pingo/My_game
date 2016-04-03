package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by ??????????? ???? on 09.03.2016.
 */
public class Sprite {
    private static final String DIRECTORY = "res/";

    public BufferedImage getImage() {
        return image;
    }

    private BufferedImage image;
    public Sprite (String filename) {
       image = null;
        try {
            image = ImageIO.read(new File(DIRECTORY + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void drawImage (Graphics g, int x, int y) {
        g.drawImage(image, x , y, null);
    }
}
