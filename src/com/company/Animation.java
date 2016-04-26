package com.company;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 23.04.2016.
 */
public class Animation {

    private String orintation="state";
    private int index=0;
    private Image[] player;
    private Image[] enemy;
    private Image[] bamboo;

    public void setOrintation(String orintation) {
        this.orintation = orintation;
    }

    public Image getPlayer(int i) {
        return player[i];
    }

    public Animation() {
        player = new Image[11];
        for(int i=0;i<11;i++){
            String index = i + ".png";
            player[i]= (new Sprite(index).getImage());
        }
    }

    public void playerAnimation(Graphics g) {
        switch (orintation){
            case "state":
                g.drawImage(player[0],Player.getX(), Player.getY(), null);
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

}
