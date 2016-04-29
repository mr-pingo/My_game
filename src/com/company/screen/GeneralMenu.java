package com.company.screen;
import com.company.handler.MouseHandler;
import com.company.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Ilya Malinovskiy on 26.04.2016.
 */
public class GeneralMenu extends Canvas implements Runnable,Scene {

    public static boolean running = false;
    private Sprite background = new Sprite("menu.jpg");
    Thread menu = new Thread(this);
    MouseHandler mouseHandler = new MouseHandler();
    @Override
    public void run() {
        Display.setMHandler(new MouseHandler());
        while (running) {
            render(Display.bs);

        }
    }



    @Override
    public synchronized void start() {
        running=true;
        menu.start();

    }

    @Override
    public synchronized void stop() {
        running=false;
        try {
            menu.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void render(BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics();
        background.drawImage(g,0,0);
        g.dispose();
        bs.show();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(long delta){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void startGame(){
        Game game = new Game();
        Display.delMHandler();
        game.start();
        menu.stop();
    }
}
