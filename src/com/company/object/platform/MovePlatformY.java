package com.company.object.platform;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 13.04.2016.
 */
public class MovePlatformY extends ShortPlatform {

    private int x;
    private int y;
    private double a = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MovePlatformY(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    private void moveY () {
        y = y + (int)(Math.cos(a)*2);
        a +=0.02;

    }

    @Override
    public void drawImage(Graphics g) {
        moveY();
        g.drawImage(sprite.getImage(),x,y,null);
    }
}
