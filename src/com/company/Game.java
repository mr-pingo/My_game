package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEALTH = 600;
    private static boolean running = false;
    private static final long SECOND = 1000/60;
    Player player = new Player();
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
            if (delta >= 1) {
                update(delta);
            }
            render();
        }
    }
    public synchronized void  start() {
    running = true;
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
        Sprite background = new Sprite("background.png");
        background.drawImage(g,0,0);
        Sprite platform = new Sprite("platform1.png");
        platform.drawImage(g, 300, 400);
        player.render(g);
        g.dispose();
        bs.show();
    }
    public void update(long delta){
        player.update();
    }
}
