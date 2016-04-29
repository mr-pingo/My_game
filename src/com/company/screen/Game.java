package com.company.screen;

import com.company.graphics.GameControlPanel;
import com.company.graphics.Sprite;
import com.company.object.Bamboo;
import com.company.object.Ladder;
import com.company.object.Player;
import com.company.object.platform.Platform;
import com.company.sound.Sound;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends Canvas implements Runnable,Scene {


    public static boolean running = false;
    private static final long SECOND = 1000/60;
    private Sprite background = new Sprite("background.jpg");
    public static ArrayList<Platform> arrayplatform = Platform.addPlatforms();
    public static Ladder ladder1 = new Ladder(103,67);
    public static Ladder ladder2 = new Ladder(924,314);
    private Player player = new Player();
    public static ArrayList<Bamboo> arrayBamboo=new ArrayList<>();
    Sound sound = new Sound(new File("res/Pin.wav"));
    Thread game =new Thread(this);

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long now;
        long delta=0;
        Display.setHandler(player.getKeyHandler());
        while (running) {
            now = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            delta+=(now / SECOND);
            update(delta);
            render(Display.bs);
        }
    }
    public synchronized void  start() {
        running = true;
        sound.play();
        Bamboo.addBamboo();
        game.start();
    }

    public synchronized void stop(){
        try {
            game.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        running=false;

    }
    public void render(BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics();
        background.drawImage(g,0,0);
        GameControlPanel.render(g);
        Platform.render(g,arrayplatform);
        ladder1.drawImage(g);
        ladder2.drawImage(g);
        Bamboo.render(g);
        player.render(g);
        g.dispose();
        bs.show();
    }
    public void update(long delta){
        if (delta >= 1) {
            Iterator<Bamboo> iterator = arrayBamboo.iterator();
            while (iterator.hasNext()) {
                Bamboo timeBamboo = iterator.next();
                timeBamboo.update();
            }
            player.update();
            delta--;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(Player.health==0)
                running=false;

        }
    }
}
