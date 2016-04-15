package com.company;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ilya Malinovskiy on 13.04.2016.
 */
public class LongPlatform extends Platform{

    public LongPlatform(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    private static Sprite sprite = new Sprite("platform2.png");

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
