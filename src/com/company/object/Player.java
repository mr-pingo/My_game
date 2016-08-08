package com.company.object;
import com.company.graphics.Animation;
import com.company.handler.KeyHandler;
import com.company.object.platform.MovePlatformX;
import com.company.object.platform.Platform;
import com.company.screen.Game;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by ����������� ���� on 10.03.2016.
 */
public class Player {

    public static Animation animation;
    private int speed;
    private KeyHandler keyHandler = new KeyHandler();
    private static int x;
    private static int y;
    private boolean playerGravity;
    private int jump;
    private boolean space;
    private int down;
    public static int health;
    public static int score;
    public static int penalty;

    public Player(){
        animation= new Animation();
        speed=2;
        x=0;
        y=415;
        playerGravity=false;
        jump=21;
        space=false;
        down=0;
        health=3;
        score=0;
        penalty=0;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public int getWidth(){
        return animation.getPlayer(0).getWidth(null);
    }

    public  int getHeight(){
        return animation.getPlayer(0).getHeight(null);
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
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
            if (((getX()+getWidth()) >(timePlatform.getX()+15)) && (getX() < (timePlatform.getX()+timePlatform.getWIDTH()-15)) && ((getY()+getHeight()) >= timePlatform.getY())&&((getY()+getHeight())<=(timePlatform.getY()+timePlatform.getHEIGHT()))) {
                //������� ��� ������ ����� �� ���������
                playerGravity=false;
                y=timePlatform.getY()-getHeight();
                if ((timePlatform.getY()==144)&&(timePlatform.getX()>=249)&&(timePlatform.getX()<=354)&&!(keyHandler.isRightpressent()||keyHandler.isLeftpressent())) {
                    x += (int)(Math.cos(MovePlatformX.a)*2);
                }
            }
//            if ((getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())) && ((getX()+getWidth()) == (timePlatform.getX()))&&((getY()+getHeight())>=timePlatform.getY())) {
//                if(keyHandler.isRightpressent())
//                    x-=speed;
//                //������� ��� ������ ����������� �����
//            }
            if ((getY() < (timePlatform.getY()+timePlatform.getHEIGHT())) && ((getX()+getWidth()) >= (timePlatform.getX()))&&((getY()+getHeight())>timePlatform.getY()) && (getX()+getWidth()<=(timePlatform.getX()+15))) {
                x = timePlatform.getX()-getWidth();
            }
//            if ((getY() <= (timePlatform.getY()+timePlatform.getHEIGHT())) && (x == (timePlatform.getX()+timePlatform.getWIDTH()))&&((getY()+getHeight())>=timePlatform.getY())){
//                //������� ��� ������ ����������� ������
//                if(keyHandler.isLeftpressent())
//                    x+=speed;
//            }
            if ((getY() < (timePlatform.getY()+timePlatform.getHEIGHT())) && (getX() <= (timePlatform.getX()+timePlatform.getWIDTH()))&&((getY()+getHeight())>timePlatform.getY())&& (getX()>=(timePlatform.getX()+timePlatform.getWIDTH()-15))){
                    x = timePlatform.getX()+timePlatform.getWIDTH();
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
                animation.setOrintation("up");
                y-=speed;
            }
            if(playerGravity&&!space) {
                animation.setOrintation("standingOnLadder");
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

        Iterator<Bamboo> iterator = Game.arrayBamboo.iterator();
        while (iterator.hasNext()) {
            Bamboo timeBamboo = iterator.next();
            if(Math.abs((getX()+getWidth()/2)-(timeBamboo.getX()+timeBamboo.getWidth()/2))<=(getWidth()/2+timeBamboo.getWidth()/2)&&(Math.abs((getY()+getHeight()/2)-(timeBamboo.getY()+timeBamboo.getHeight()/2))<=(getHeight()/2+timeBamboo.getHeight()/2))) {
                Bamboo.takeBamboo(timeBamboo);
                return;
            }
        }
        Iterator<Enemy> iter = Game.arrayenemy.iterator();
        while (iter.hasNext()) {
            Enemy timeEnemy = iter.next();
            if(Math.abs((getX()+getWidth()/2)-(timeEnemy.getX()+timeEnemy.getWIDTH()/2)-35)<=(getWidth()/2+timeEnemy.getWIDTH()/2)&&(Math.abs((getY()+getHeight()/2)-(timeEnemy.getY()+timeEnemy.getHEIGHT()/2)-35)<=(getHeight()/2+timeEnemy.getHEIGHT()/2))) {
                x = 0;
                y = 415;
                health--;
            }
        }
    }

    public void render(Graphics g){
        animation.playerAnimation(g);
    }

    public void update() {
        gravity();

        if ((keyHandler.isLeftpressent() == false)) {
            animation.setOrintation("state");
        }
        if ((keyHandler.isRightpressent() == false)) {
            animation.setOrintation("state");
        }
        if ((keyHandler.isLeftpressent() == true) && (x >= 2)) {
            animation.setOrintation("left");
            x -= speed;
        }
        if (keyHandler.isRightpressent() == true && (x <= 1236)) {
            animation.setOrintation("right");
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