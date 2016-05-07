package com.company;

import com.company.screen.Display;
import com.company.screen.GeneralMenu;

/**
 * Created by ??????????? ???? on 09.03.2016.
 */
public class Main {
    public static final String NAME_GAME="Накорми панду";
    public static final int WIDTH = 1280;
    public static final int HEALTH = 600;
    public static GeneralMenu menu;

    public static void main(String[] args) {
        menu = new GeneralMenu();
        new Display(NAME_GAME,WIDTH, HEALTH,menu);
        menu.startMenu();

    }
}
