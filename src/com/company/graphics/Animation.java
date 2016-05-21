package com.company.graphics;

import com.company.object.Player;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 23.04.2016.
 */
public class Animation {

    private String orintation="state";
    private int index=0;
    private int number = 0;
    private Image[] player;
    private Image[] enemy;
    private Image[] bamboo;

    public void setOrintation(String orintation) {
        this.orintation = orintation;
    }

    public Image getPlayer(int i) {
        return player[i];
    }

    public Image getEnemy(int i) {
        return enemy[i];
    }

    public Animation() {
        player = new Image[11];
        for(int i=0;i<11;i++){
            String index = i + ".png";
            player[i]= (new Sprite(index).getImage());
        }
        enemy = new Image[17];
        for (int i = 0; i < 17; i++) {
            String index = "enemy" + i + ".png";
            enemy[i] = (new Sprite(index).getImage());
        }
    }

    public void playerAnimation(Graphics g) {
        switch (orintation){
            case "state":
                g.drawImage(player[0], Player.getX(), Player.getY(), null);
                return;
            case "standingOnLadder":
                g.drawImage(player[9],Player.getX(), Player.getY(), null);
                return;
            case "up":
                if(index>=0 && index<15)
                    g.drawImage(player[9],Player.getX(), Player.getY(), null);
                if(index>=15 && index<30) {
                    g.drawImage(player[10], Player.getX(), Player.getY(), null);
                    index=0;
                }
                index+=3;
                return;
            case "left":
                if(index>=0 && index<5)
                    g.drawImage(player[5], Player.getX(), Player.getY(), null);
                if(index>=5 && index<10)
                    g.drawImage(player[6], Player.getX(), Player.getY(), null);
                if(index>=10 && index<15)
                    g.drawImage(player[7],Player.getX(), Player.getY(), null);
                if(index>=15 && index<20)
                    g.drawImage(player[8],Player.getX(), Player.getY(), null);
                if(index>=20 && index<25)
                    g.drawImage(player[7],Player.getX(), Player.getY(), null);
                if(index>=25 && index<=30) {
                    g.drawImage(player[6],Player.getX(), Player.getY(), null);
                    index=0;
                }
                index++;
                return;
            case "right":
                if(index>=0 && index<5)
                    g.drawImage(player[1],Player.getX(), Player.getY(), null);
                if(index>=5 && index<10)
                    g.drawImage(player[2],Player.getX(), Player.getY(), null);
                if(index>=10 && index<15)
                    g.drawImage(player[3], Player.getX(), Player.getY(), null);
                if(index>=15 && index<20)
                    g.drawImage(player[4],Player.getX(), Player.getY(), null);
                if(index>=20 && index<25)
                    g.drawImage(player[3],Player.getX(), Player.getY(), null);
                if(index>=25 && index<=30) {
                    g.drawImage(player[2],Player.getX(), Player.getY(), null);
                    index=0;
                }
                index++;
                return;
        }
    }

    public void enemyAnimation(Graphics g, int x, int y, String direction) {
        if (direction == "right") {
            if (number >= 0 && number < 25)
                g.drawImage(enemy[0], x, y, null);
            if (number >= 25 && number < 50)
                g.drawImage(enemy[1], x, y, null);
            if (number >= 50 && number < 75)
                g.drawImage(enemy[2], x, y, null);
            if (number >= 75 && number < 100)
                g.drawImage(enemy[3], x, y, null);
            if (number >= 100 && number < 125)
                g.drawImage(enemy[4], x, y, null);
            if (number >= 125 && number < 150)
                g.drawImage(enemy[5], x, y, null);
            if (number >= 150 && number < 175)
                g.drawImage(enemy[6], x, y, null);
            if (number >= 175 && number <= 200) {
                g.drawImage(enemy[7], x, y, null);
                number = 0;
            }
            number++;
        }
        else {
            if (number >= 0 && number < 25)
                g.drawImage(enemy[8], x, y, null);
            if (number >= 25 && number < 50)
                g.drawImage(enemy[9], x, y, null);
            if (number >= 50 && number < 75)
                g.drawImage(enemy[10], x, y, null);
            if (number >= 75 && number < 100)
                g.drawImage(enemy[11], x, y, null);
            if (number >= 100 && number < 125)
                g.drawImage(enemy[12], x, y, null);
            if (number >= 125 && number < 150)
                g.drawImage(enemy[13], x, y, null);
            if (number >= 150 && number < 175)
                g.drawImage(enemy[14], x, y, null);
            if (number >= 175 && number <= 200) {
                g.drawImage(enemy[15], x, y, null);
                number = 0;
            }
            number++;
        }
    }

}
