package com.company.object;

import com.company.graphics.Sprite;
import com.company.object.platform.MovePlatformX;
import com.company.object.platform.Platform;
import com.company.screen.Game;

import java.awt.*;
import java.util.*;

/**
 * Created by Ilya Malinovskiy on 13.04.2016.
 */
public class Bamboo {
    private int x;
    private int y;
    private int time=0;
    private static Sprite sprite = new Sprite("Bambukovaya_palochka.png");
    private boolean bambooGravity = false;
    private final int WIDTH = sprite.getImage().getWidth(null);
    private final int HEIGHT = sprite.getImage().getHeight(null);
    private Random rnd = new Random();
    private Timer timer = new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public  void run() {
            if (Game.isPause) {

            }else{
                time++;
                if (time == 7) {
                    deleteBamboo();
                    Player.penalty++;
                    time = 0;
                    if (Game.arrayBamboo.size() == 0)
                        addBamboo();
                    if (Player.penalty == 3) {
                        Player.health--;
                        Player.penalty = 0;
                    }
                    stopTimer();
                }

        }
        }
    };

    public Bamboo() {
        x=rnd.nextInt(1280-WIDTH);
        y=rnd.nextInt(480-HEIGHT);
        timer.schedule(task,1000,1000);
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public void gravity(){
        if(bambooGravity) {
            y+=3;
        }
    }

    public static void addBamboo(){
            Game.arrayBamboo.add(new Bamboo());
        if(Player.score>=5)
            Game.arrayBamboo.add(new Bamboo());
        if(Player.score>=10)
            Game.arrayBamboo.add(new Bamboo());
    }

    public void physics() {
        Iterator<Platform> i = Game.arrayplatform.iterator();
        while (i.hasNext()) {
            Platform timePlatform = i.next();
            if (((getX() + getWidth()) > (timePlatform.getX())) && (x < (timePlatform.getX() + timePlatform.getWIDTH())) && ((getY() + getHeight()) >= timePlatform.getY()) && ((getY() + getHeight()) <= (timePlatform.getY() + timePlatform.getHEIGHT()))) {
                bambooGravity = false;
                y = timePlatform.getY() - getHeight();
                if ((timePlatform.getY() == 144) && (timePlatform.getX() >= 249) && (timePlatform.getX() <= 354)) {
                    x += (int) (Math.cos(MovePlatformX.a) * 2);
                }
            }
        }
    }

    public static void takeBamboo(Bamboo bamboo){
        if(Game.arrayBamboo.size()>1) {
            Game.arrayBamboo.remove(bamboo);
            Player.score++;
            bamboo.stopTimer();
         }
        else {
            Game.arrayBamboo.remove(bamboo);
            Player.score++;
            addBamboo();
            bamboo.stopTimer();
        }
    }

    public void deleteBamboo(){
        Game.arrayBamboo.remove(this);
    }

    public void drawImage(Graphics g) {
        g.drawImage(sprite.getImage(),x,y,null);
    }

    public void stopTimer(){
        timer.cancel();
    }

    public static void render(Graphics g) {
        for (Bamboo bamboo1 : Game.arrayBamboo) {
            bamboo1.drawImage(g);
        }
    }


    public void update(){
       gravity();
        if(y<440)
            bambooGravity=true;
        else
            bambooGravity=false;
        physics();
        if(Game.running==false)
            stopTimer();
    }
}
