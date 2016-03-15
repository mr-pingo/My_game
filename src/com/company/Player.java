package com.company;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Малиновский Илья on 10.03.2016.
 */
public class Player {

    private Image[] animation; //массив картинок для анимации
    private int a;//
    private int b;// переменные для хранения номера картинки, для анимации
    private int c;//
    private KeyHandler keyHandler = new KeyHandler();
    private int x=0;
    private int y=403;
    private boolean playerGravity=false;
    private int jump =21; // изменение координаты y при прыжке
    private Platform platform = new Platform();
    ArrayList<Platform> arrayPlatforms = platform.getPlatforms();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth(){
        return animation[0].getWidth(null); // получение ширины картинки
    }

    public  int getHeight(){
        return animation[0].getHeight(null); // получение высоты картинки
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    } // что бы работала клавиатура

    public Player(){
       animation = new Image[8];
        for(int i=0;i<8;i++){
            String index = i+1 + ".png";
            animation[i]= (new Sprite(index).getImage());   //заполнение массива картинками
        }
    }

    private void whoImage (int a, int b,int c) {      //для определения нужныж картинок анимации
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void whoImage(int a){
        this.a = a;
        b = a;
        c = a;
    }

    int index=0;
    public void drawImage (Graphics g, int x, int y) {  // имитируем анимацию
        if (index == 1)
            g.drawImage(animation[a], x, y, null);
        if (index == 2)
            g.drawImage(animation[b], x, y, null);
        if (index == 3)
            g.drawImage(animation[c], x, y, null);
        if (index == 4) {
            g.drawImage(animation[b], x, y, null);
            index = 0;
        }
        index++;
    }

    public void gravity(){
        if(playerGravity) {
            y+=7;
        }
    }

    public void render(Graphics g){
        drawImage(g,x,y);
    }

    public void update() {
        gravity();
        if(y<403)
            playerGravity=true;
        else
            playerGravity=false;
        if ((keyHandler.isLeftpressent() == false)) {
            whoImage(0);
        }
        if ((keyHandler.isRightpressent() == false)) {
            whoImage(0);
        }
        if ((keyHandler.isLeftpressent() == true) && (x >= 2)) {
            whoImage(4, 7, 5);
            x -= 2;
        }
        if (keyHandler.isRightpressent() == true && (x <= 754)) {
            whoImage(1, 6, 2);
            x += 2;
        }
        if (keyHandler.isSpacepressent() == true) {
            if (jump >0) {
                y-=jump;
                jump--;
            }
            else {
                keyHandler.setSpacepressent(false);
                jump =21;
            }
        }
        Iterator<Platform> i = arrayPlatforms.iterator();
        while(i.hasNext()) {
            Platform timePlatform = i.next();
            if (((getX()+getWidth()) >(timePlatform.getX())) && (x < (timePlatform.getX()+timePlatform.getWIDTH())) && ((getY()+getHeight()) >= timePlatform.getY())&&((getY()+getHeight())<=(timePlatform.getY()+timePlatform.getHEIGHT()))) {
                //условие что зайчик стоит на платформе
                playerGravity=false;
            }
            if (((getX()+getWidth()) >= (timePlatform.getX())) && (x <=(timePlatform.getX()+timePlatform.getWIDTH())) && (getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())&& (getY() > (timePlatform.getY())))) {
                //Условие что зайчик остановится ударившись головой об платформу
               keyHandler.setSpacepressent(false);
                jump=21;
            }
             if ((getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())) && ((getX()+getWidth()) == (timePlatform.getX()))&&((getY()+getHeight())>=timePlatform.getY())) {
                    if(keyHandler.isRightpressent())
                    x-=2;
                //условие что зайчик отсановится слева
            }
            if ((getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())) && (x == (timePlatform.getX()+timePlatform.getWIDTH()))&&((getY()+getHeight())>=timePlatform.getY())){
                //условие что зайчик отсановится справа
                if(keyHandler.isLeftpressent())
                    x+=2;
            }
        }
    }
}