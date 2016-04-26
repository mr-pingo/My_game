package com.company;

/**
 * Created by ??????????? ???? on 09.03.2016.
 */
public class Main {
    public static final String NAME_GAME="Накорми панду";
    public static final int WIDTH = 1280;
    public static final int HEALTH = 600;

    public static void main(String[] args) {
        Game game = new Game();
        new Display(NAME_GAME,WIDTH, HEALTH,game);
        game.start();

    }
}
