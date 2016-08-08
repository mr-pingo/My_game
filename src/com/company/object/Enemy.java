package com.company.object;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Компьютер on 20.05.2016.
 */
public class Enemy {
    private int x;
    private int y;
    private int speed = 1;
    private String direction = "right";
    private final int WIDTH = Player.animation.getEnemy(0).getWidth(null);
    private final int HEIGHT = Player.animation.getEnemy(0).getHeight(null);

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static ArrayList<Enemy> addEnemy() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(510,140));
        enemies.add(new Enemy(370, 353));
        return enemies;
    }

    private void move (){
        switch (direction){
            case "right":
                x += speed;
                if ((x+WIDTH == 789)||(x+WIDTH == 580)){
                    direction = "left";
                }
                return;
            case "left":
                x -= speed;
                if ((x == 510)||(x == 280)) {
                    direction = "right";
                }
                return;
        }
    }

    public void drawImage(Graphics g) {
        Player.animation.enemyAnimation(g,x,y,direction);
    }

    public static void render(Graphics g, ArrayList<Enemy> enemy) {
        for (Enemy enemy1 : enemy) {
            enemy1.drawImage(g);
            enemy1.move();
        }
    }
}
