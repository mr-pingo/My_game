package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;

public class Game extends Canvas implements Runnable {


    private static boolean running = false;
    private static final long SECOND = 1000/60;
    private Sprite background = new Sprite("background.jpg");
    private Player player = new Player();
    private Platform platform = new Platform();
    Sound sound = new Sound(new File("res/Pin.wav"));
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long now;
        long delta=0;
        addKeyListener(player.getKeyHandler());

        while (running) {
            now = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            delta+=(now / SECOND);
            update(delta);
            render();
        }
    }
    public synchronized void  start() {
        running = true;
        sound.play();
        new Thread(this).start();
    }
    public void render() {
        BufferStrategy bs = getBufferStrategy();
       if (bs == null) {
           createBufferStrategy(3);
           requestFocus();
           return ;
       }
        Graphics g = bs.getDrawGraphics();
        background.drawImage(g,0,0);
        platform.render(g);
        player.render(g);
        g.dispose();
        bs.show();
    }
    public void update(long delta){
        if (delta >= 1) {
            player.update();
            delta--;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
