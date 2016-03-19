package com.company;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ����������� ���� on 10.03.2016.
 */
public class Player {

    private Image[] animation; //������ �������� ��� ��������
    private int a;//
    private int b;// ���������� ��� �������� ������ ��������, ��� ��������
    private int c;//
    private int speed =2;
    private KeyHandler keyHandler = new KeyHandler();
    private int x=0;
    private int y=403;
    private boolean playerGravity=false;
    private int jump =21;// ��������� ���������� y ��� ������
    private boolean space=false;
    private Platform platform = new Platform();
    ArrayList<Platform> arrayPlatforms = platform.getPlatforms();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth(){
        return animation[0].getWidth(null); // ��������� ������ ��������
    }

    public  int getHeight(){
        return animation[0].getHeight(null); // ��������� ������ ��������
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    } // ��� �� �������� ����������

    public Player(){
       animation = new Image[8];
        for(int i=0;i<7;i++){
            String index = i + ".png";
            animation[i]= (new Sprite(index).getImage());   //���������� ������� ����������
        }
    }

    private void whoImage (int a, int b,int c) {      //��� ����������� ������ �������� ��������
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
    public void drawImage (Graphics g, int x, int y) {  // ��������� ��������
       if(index>=0 && index<5)
           g.drawImage(animation[a], x, y, null);
        if(index>=5 && index<10)
            g.drawImage(animation[b], x, y, null);
        if(index>=10 && index<15)
            g.drawImage(animation[c], x, y, null);
        if(index>=15 && index<=20){
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
            whoImage(4, 5, 6);
            x -= speed;
        }
        if (keyHandler.isRightpressent() == true && (x <= 754)) {
            whoImage(1, 2, 3);
            x += speed;
        }
        if (keyHandler.isSpacepressent() == true && !playerGravity) {
            space = true;
        }

        jump(space);

        if(y<403)
            playerGravity=true;
        else
            playerGravity=false;

        Iterator<Platform> i = arrayPlatforms.iterator();
        while(i.hasNext()) {
            Platform timePlatform = i.next();
            if (((getX()+getWidth()) >(timePlatform.getX())) && (x < (timePlatform.getX()+timePlatform.getWIDTH())) && ((getY()+getHeight()) >= timePlatform.getY())&&((getY()+getHeight())<=(timePlatform.getY()+timePlatform.getHEIGHT()))) {
                //������� ��� ������ ����� �� ���������
                playerGravity=false;
            }
            if (((getX()+getWidth()) >= (timePlatform.getX())) && (x <=(timePlatform.getX()+timePlatform.getWIDTH())) && (getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())&& (getY() > (timePlatform.getY())))) {
                //������� ��� ������ ����������� ���������� ������� �� ���������
                space=false;
                jump=21;
            }
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
    }
}