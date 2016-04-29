package com.company.object.platform;

import com.company.graphics.Sprite;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 13.04.2016.
 */
public class ShortPlatform extends Platform {

    public ShortPlatform(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    protected static Sprite sprite = new Sprite("platform1.png");

    private static final int WIDTH = sprite.getImage().getWidth(null);
    private static final int HEIGHT = sprite.getImage().getHeight(null);


    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void drawImage(Graphics g) {
        g.drawImage(sprite.getImage(),x,y,null);
    }
}

