package com.company;

import java.awt.*;

/**
 * Created by Ilya Malinovskiy on 22.04.2016.
 */
public class GameControlPanel {
    public static void render(Graphics g) {
        //Score
        g.setColor(new Color(232, 232, 16));
        g.setFont(new Font("TimesRoman", Font.BOLD|Font.ITALIC, 24));
        g.drawString("Очки: " + Bamboo.score, 5, 550);

        //Health
        g.drawString("Здоровье: "+ Player.health,5,570);

        //Penalty
        g.drawString("Штраф: "+ Bamboo.penalty,5,590);

    }
}
