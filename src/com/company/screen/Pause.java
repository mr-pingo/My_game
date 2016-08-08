package com.company.screen;

import com.company.graphics.Sprite;
import com.company.handler.KeyHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Ilya Malinovskiy on 02.07.2016.
 */
public class Pause extends Canvas implements Runnable,Scene{

    public static boolean running =false;
    private Sprite background;
    Thread pause;
    KeyHandler keyPause;

    @Override
    public void run() {
        keyPause= new KeyHandler();
        background = new Sprite("pause.jpg");
        while (running){
            Display.setHandler(keyPause);
            render(Display.bs);
            update(0);
        }
    }

    public Thread getPause() {
        return pause;
    }

    @Override
    public synchronized void start() {
        running=true;
        pause = new Thread(this);
        pause.start();
    }

    @Override
    public synchronized void stop() {
        running=false;
        Display.delHandler(keyPause);
    }

    @Override
    public void render(BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics();
        background.drawImage(g,0,0);
        g.dispose();
        bs.show();
    }

    @Override
    public void update(long delta) {
        if(keyPause.isEscpressent()){
            stop();
            Game.isPause=false;
        }
    }
}
