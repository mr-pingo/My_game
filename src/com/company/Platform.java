package com.company;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ??????????? ???? on 12.03.2016.
 */
public class Platform {

    private int x;
    private int y;
    private static Sprite platform= new Sprite("platform1.png");
    private static final int WIDTH = platform.getImage().getWidth(null);
    private static final int HEIGHT = platform.getImage().getHeight(null);

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    ArrayList<Platform> platforms = new ArrayList<>();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public Platform(){  // ?????, ?? ???????!
        addPlatforms();
    }

    public  Platform(int x , int y){
        this.x= x;
        this.y= y;
    }

    private void addPlatforms(){ //?????????? ???????? ? ?????????
        platforms.add(new Platform(232,404));
        platforms.add(new Platform(467,315));
        platforms.add(new Platform(516,207));
        platforms.add(new Platform(321,144));
        platforms.add(new Platform(85,67));
        platforms.add(new Platform(22,251));
        platforms.add(new Platform(801,114));
        platforms.add(new Platform(995,174));
        platforms.add(new Platform(875,314));
        platforms.add(new Platform(1129,66));

    }

    public void drawImage(Graphics g){
        g.drawImage(platform.getImage(),x,y,null);
    }

    public void render(Graphics g){  //???? foreach ??? ??????????? ?? ?????????
        for (Platform platform1 :platforms) {
            platform1.drawImage(g);
        }

    }

}
