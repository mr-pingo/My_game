package com.company.graphics;

import com.company.object.Bamboo;
import com.company.object.Player;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 22.04.2016.
 */
public class GameControlPanel {
    private static Sprite score = new Sprite("Bambuk.png");
    private static Sprite panda = new Sprite("Panda.png");
    private static Sprite health0 = new Sprite("Zhizn_0.png");
    private static Sprite health1 = new Sprite("Zhizn_1.png");
    private static Sprite health2 = new Sprite("Zhizn_2.png");
    private static Sprite health3 = new Sprite("Zhizn_3.png");
    private static Sprite penalty0 = new Sprite("Bambuk_3.png");
    private static Sprite penalty1 = new Sprite("Bambuk_2.png");
    private static Sprite penalty2 = new Sprite("Bambuk_1.png");
    private static Sprite penalty3 = new Sprite("Bambuk_0.png");
    public static void render(Graphics g) {
        //Score
        g.drawImage(score.getImage(),11,542,null);
        g.setColor(new Color(239,226,0));
        g.setFont(new Font("TimesRoman", Font.BOLD|Font.ITALIC, 18));
        g.drawString("X  " + Player.score, 74, 578);

        //Health
        g.drawImage(panda.getImage(),541,546,null);
        if(Player.health==3)
            g.drawImage(health3.getImage(),613,560,null);
        if(Player.health==2)
            g.drawImage(health2.getImage(),613,560,null);
        if(Player.health==1)
            g.drawImage(health1.getImage(),613,560,null);
        if(Player.health==0)
            g.drawImage(health0.getImage(),613,560,null);

        //Penalty
        if(Player.penalty==0)
            g.drawImage(penalty0.getImage(),1065,548,null);
        if(Player.penalty==1)
            g.drawImage(penalty1.getImage(),1065,548,null);
        if(Player.penalty==2)
            g.drawImage(penalty2.getImage(),1065,548,null);
        if(Player.penalty==3)
            g.drawImage(penalty3.getImage(),1065,548,null);

    }
}
