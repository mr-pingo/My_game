package com.company;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Малиновский Илья on 12.03.2016.
 */
public class Platform {

    private int x;
    private int y;
    private static Sprite platform= new Sprite("platform1.png");
    private static final int WIDTH = platform.getImage().getWidth(null);
    private static final int HEIGHT = platform.getImage().getHeight(null);
    ArrayList<Platform> platforms = new ArrayList();

    public int getX() {
        return x;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
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

    public Platform(){  // магия, не трогать!
        addPlatforms();
    }

    public  Platform(int x , int y){
        this.x= x;
        this.y= y;
    }

    private void addPlatforms(){ //добавление платформ в коллекцию
        platforms.add(new Platform(300,400));
        platforms.add(new Platform(600,350));
        platforms.add(new Platform(400,200));
        platforms.add(new Platform(150,150));

    }

    public void drawImage(Graphics g){
        g.drawImage(platform.getImage(),x,y,null);
    }

    public void render(Graphics g){  //цикл foreach для прохождения по коллекции
        for (Platform platform1 :platforms) {
            platform1.drawImage(g);
        }

    }

}
