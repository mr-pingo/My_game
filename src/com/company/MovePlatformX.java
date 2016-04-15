package com.company;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 13.04.2016.
 */
public class MovePlatformX extends ShortPlatform{
    private int x;
    private int y;
    public static double a = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public MovePlatformX(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    private void moveX () {
        x = x + (int)(Math.cos(a)*2);
        a +=0.02;
    }

    @Override
    public void drawImage(Graphics g) {
        moveX();
        g.drawImage(sprite.getImage(),x,y,null);
    }
}
