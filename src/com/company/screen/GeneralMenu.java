package com.company.screen;
import com.company.Main;
import com.company.graphics.Sprite;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

/**
 * Created by Ilya Malinovskiy on 26.04.2016.
 */
public class GeneralMenu extends Canvas implements Runnable,Scene, MouseListener, MouseMotionListener {

    public static boolean running = false;
    private Sprite[] button = new Sprite[7];
    public  static  boolean isStartButton=false;
    public  static  boolean isScoreButton=false;
    public  static  boolean isExitButton=false;
    private Sprite background;
    Thread thread;

    public GeneralMenu() {
        background= new Sprite("menu.jpg");
        for (int i=1;i<7;i++)
        button[i]=new Sprite("button"+i+".png");
    }

    @Override
    public void run() {
        Display.setMouseListener(this,this);
        while (running) {
            render(Display.bs);
        }
    }


    @Override
    public synchronized void start() {
        running=true;
        thread=new Thread(this);
        thread.start();

    }

    @Override
    public synchronized void stop() {
        running=false;
            thread.stop();

    }

    @Override
    public void render(BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics();
        background.drawImage(g,0,0);
        drawButton(g);
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

    }

    public void startGame(){
        Game game = new Game();
        game.start();
        Display.delMouseListener(this,this);
        stop();
    }

    private void drawButton(Graphics g){
        if(!isStartButton)
            button[1].drawImage(g,96,90);
        else
            button[4].drawImage(g,96,90);
        if(!isScoreButton)
            button[2].drawImage(g,96,224);
        else
            button[5].drawImage(g,96,224);
        if(!isExitButton)
            button[3].drawImage(g,96,367);
        else
            button[6].drawImage(g,96,367);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ((e.getX() >= 96 && e.getX() <= 96 + button[1].getwidth()) && (e.getY() >= 90 && e.getY() <= 90 + button[1].getheight()))
            Main.menu.startGame();
        if ((e.getX() >= 96 && e.getX() <= 96 + button[3].getwidth()) && (e.getY() >= 367 && e.getY() <= 367 + button[3].getheight()))
            System.exit(0);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((e.getX() >= 96 && e.getX() <= 96 + button[1].getwidth()) && (e.getY() >= 90 && e.getY() <= 90 + button[1].getheight()))
            isStartButton=true;
        else
            isStartButton=false;
        if ((e.getX() >= 96 && e.getX() <= 96 + button[2].getwidth()) && (e.getY() >= 224 && e.getY() <= 224 + button[2].getheight()))
            isScoreButton=true;
        else
            isScoreButton=false;
        if ((e.getX() >= 96 && e.getX() <= 96 + button[3].getwidth()) && (e.getY() >= 367 && e.getY() <= 367 + button[3].getheight()))
            isExitButton=true;
        else
            isExitButton=false;
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

}

