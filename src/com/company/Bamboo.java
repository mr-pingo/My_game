package com.company;

import java.awt.*;
import java.util.Random;

/**
 * Created by Ilya Malinovskiy on 13.04.2016.
 */
public class Bamboo {
    private int x;
    private int y;
    private static Sprite sprite = new Sprite("Bambukovaya_palochka.png");
    private boolean bambooGravity = false;
    private static final int WIDTH = sprite.getImage().getWidth(null);
    private static final int HEIGHT = sprite.getImage().getHeight(null);
    Random rnd = new Random();

    public Bamboo() {
        x=rnd.nextInt(1280-WIDTH);
        y=rnd.nextInt(480-HEIGHT);
    }
    public void gravity(){
        if(bambooGravity) {
            y+=7;
        }
    }



    public void render(Graphics g){
        g.drawImage(sprite.getImage(),x,y,null);
    }

    public void update(){
       gravity();
        if(y<415)
            bambooGravity=true;
        else
            bambooGravity=false;
    }
}
