package com.company;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ����������� ���� on 12.03.2016.
 */
public class Platform {

    private static int x;
    private static int y;
    private ArrayList<Image> imagesPlatforms = new ArrayList();
    Sprite platform = new Sprite("platform1.png");

    public  Platform(){

    }

    public void drawImage(Graphics g,int x,int y){
        g.drawImage(platform.getImage(),x,y,null);
    }

}
