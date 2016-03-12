package com.company;

import java.awt.*;

/**
 * Created by Малиновский Илья on 10.03.2016.
 */
public class Player {

    private Image[] animation; //массив картинок для анимации
    private int a;//
    private int b;// переменные для хранения номера картинки, для анимации
    private int c;//
    private static final int START_Y_POSITION=403;
    private KeyHandler keyHandler = new KeyHandler();
    private int x=0;
    private int y=START_Y_POSITION;
    private int jump =0; // изменение координаты y при прыжке
    private float q=0; //переменная изменения cos

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void whoImage (int a, int b,int c) {      //для определения нужныж картинок анимации
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void whoImage(int a){
        this.a = a;
        b = a;
        c = a;
    }

    int index=0;
    public void drawImage (Graphics g, int x, int y) {  // имитируем анимацию
        if(index==1)
            g.drawImage(animation[a], x , y, null);
        if(index==2)
            g.drawImage(animation[b], x , y, null);
        if(index==3)
          g.drawImage(animation[c], x, y, null);
        if(index==4){
            g.drawImage(animation[b], x , y, null);
            index=0;
        }
        index++;
    }

    public void render(Graphics g){
        drawImage(g,x,y=(START_Y_POSITION- jump));
    }

    public void update(){
        if((keyHandler.isLeftpressent() == false)){
            whoImage(0);
        }
        if((keyHandler.isRightpressent()== false)){
            whoImage(0);
        }
        if((keyHandler.isLeftpressent() == true)&&(x>=2)) {
            whoImage(4, 7, 5);
            x-=2;
        }
        if(keyHandler.isRightpressent() == true&&(x<=754)) {
            whoImage(1, 6, 2);
            x+=2;
        }
        if(keyHandler.isSpacepressent()==true){
            if (q<3.2) {
                float b = (float) Math.sin(q) * 100;
                q += 0.11;
                jump = (int) b;
            }
            else {
                q = 0;
                jump =0;
                keyHandler.setSpacepressent(false);
            }
        }
    }
}
