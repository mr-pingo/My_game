package com.company;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ����������� ���� on 10.03.2016.
 */
public class Player {

    private Image[] animation;
    private int a;
    private int b;
    private int c;
    private int d;
    private int speed =2;
    private KeyHandler keyHandler = new KeyHandler();
    private int x=0;
    private int y=415;
    private boolean playerGravity=false;
    private int jump =21;
    private boolean space=false;
    private int index=0;
    private int down = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth(){
        return animation[0].getWidth(null);
    }

    public  int getHeight(){
        return animation[0].getHeight(null);
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public Player(){
       animation = new Image[9];
        for(int i=0;i<9;i++){
            String index = i + ".png";
            animation[i]= (new Sprite(index).getImage());
        }
    }

    private void whoImage (int a, int b,int c,int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private void whoImage(int a){
        this.a = a;
        b = a;
        c = a;
        d=a;
    }


    public void drawImage (Graphics g, int x, int y) {  // ��������� ��������
       if(index>=0 && index<5)
           g.drawImage(animation[a], x, y, null);
        if(index>=5 && index<10)
            g.drawImage(animation[b], x, y, null);
        if(index>=10 && index<15)
            g.drawImage(animation[c], x, y, null);
        if(index>=15 && index<20)
            g.drawImage(animation[d], x, y, null);
        if(index>=20 && index<25)
            g.drawImage(animation[c], x, y, null);
        if(index>=25 && index<=30) {
            g.drawImage(animation[b], x, y, null);
            index=0;
        }
        index++;
    }

    public void gravity(){
        if(playerGravity) {
            y+=7;
        }
    }

    public void jump (boolean space){
        if (space) {
            if (jump >0) {
                y-=jump;
                jump--;
            }
            else {
                this.space=false;
                jump =21;
            }
        }
    }

    public void physics(){
        Iterator<Platform> i = Game.arrayplatform.iterator();
        while(i.hasNext()) {
            Platform timePlatform = i.next();
            if (((getX()+getWidth()) >(timePlatform.getX())) && (x < (timePlatform.getX()+timePlatform.getWIDTH())) && ((getY()+getHeight()) >= timePlatform.getY())&&((getY()+getHeight())<=(timePlatform.getY()+timePlatform.getHEIGHT()))) {
                //������� ��� ������ ����� �� ���������
                playerGravity=false;
                y=timePlatform.getY()-getHeight();
                if ((timePlatform.getY()==144)&&(timePlatform.getX()>=249)&&(timePlatform.getX()<=354)) {
                    x += (int)(Math.cos(MovePlatformX.a)*2);
                }
            }
//            if (((getX()+getWidth()) >= (timePlatform.getX())) && (x <=(timePlatform.getX()+timePlatform.getWIDTH())) && (getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())&& (getY() > (timePlatform.getY())))) {
//                //������� ��� ������ ����������� ���������� ������� �� ���������
//                space=false;
//                jump=21;
//            }
            if ((getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())) && ((getX()+getWidth()) == (timePlatform.getX()))&&((getY()+getHeight())>=timePlatform.getY())) {
                if(keyHandler.isRightpressent())
                    x-=speed;
                //������� ��� ������ ����������� �����
            }
            if ((getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())) && (x == (timePlatform.getX()+timePlatform.getWIDTH()))&&((getY()+getHeight())>=timePlatform.getY())){
                //������� ��� ������ ����������� ������
                if(keyHandler.isLeftpressent())
                    x+=speed;
            }
        }
        if(((getX()+getWidth()<=Game.ladder1.getX()+Game.ladder1.getWIDTH())&&(getX()>=Game.ladder1.getX())&&(getY()<=Game.ladder1.getY()+Game.ladder1.getHEIGHT())&&(getY()+getHeight()>=Game.ladder1.getY()))||
        ((getX()+getWidth()<=Game.ladder2.getX()+Game.ladder2.getWIDTH())&&(getX()>=Game.ladder2.getX())&&(getY()<=Game.ladder2.getY()+Game.ladder2.getHEIGHT())&&(getY()+getHeight()>=Game.ladder2.getY()))) {
            if(keyHandler.isDownpressent()&&(getY()<=415)&&(((getY()+getHeight()<Game.ladder1.getY()+Game.ladder1.getHEIGHT()-2)&&(getY()+getHeight()>=Game.ladder1.getY()))||
                    (getY()+getHeight()<Game.ladder2.getY()+Game.ladder2.getHEIGHT())&&(getY()+getHeight()>=Game.ladder2.getY()))) {
                if(!playerGravity) {
                    if(down == 0) {
                        down = y;
                    }
                    y = down + speed;
                    down = y;
                }
                else {
                    down = 0;
                    y += speed;
                }
            }
            if (keyHandler.isUppressent() == true) {
                y-=speed;
            }
            if(playerGravity&&!space) {
                y-=7;
                if(keyHandler.isLeftpressent() == true){
                    x+=speed;
                }
                if(keyHandler.isRightpressent() == true) {
                    x -= speed;
                }
            }
        }
        else
            down = 0;
    }

    public void render(Graphics g){
        drawImage(g,x,y);
    }

    public void update() {
        gravity();

        if ((keyHandler.isLeftpressent() == false)) {
            whoImage(0);
        }
        if ((keyHandler.isRightpressent() == false)) {
            whoImage(0);
        }
        if ((keyHandler.isLeftpressent() == true) && (x >= 2)) {
            whoImage(5, 6, 7,8);
            x -= speed;
        }
        if (keyHandler.isRightpressent() == true && (x <= 1236)) {
            whoImage(1, 2, 3, 4);
            x += speed;
        }
        if (keyHandler.isSpacepressent() == true && !playerGravity) {
            space = true;
        }

        jump(space);

        if(y<415)
            playerGravity=true;
        else
            playerGravity=false;

        physics();
    }
}