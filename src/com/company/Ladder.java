package com.company;

import java.awt.*;

/**
 * Created by Компьютер on 17.04.2016.
 */
public class Ladder {

    private int x;
    private int y;

    private Sprite sprite = new Sprite("ladder.png");

    public Ladder(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private final int WIDTH = sprite.getImage().getWidth(null);
    private final int HEIGHT = sprite.getImage().getHeight(null);


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

    public void drawImage(Graphics g) {
        g.drawImage(sprite.getImage(), x, y, null);
    }

}
