package com.company;

import java.awt.*;

/**
 * Created by Малиновский Илья on 12.03.2016.
 */
public class Platform {

    private int x;
    private int y;
    private static Sprite platform= new Sprite("platform1.png");
    private static final int WIDTH = platform.getImage().getWidth(null);
    private static final int HEIGHT = platform.getImage().getHeight(null);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public  Platform(int x , int y){
        this.x= x;
        this.y= y;
    }

    public void drawImage(Graphics g){
        g.drawImage(platform.getImage(),x,y,null);
    }

}
