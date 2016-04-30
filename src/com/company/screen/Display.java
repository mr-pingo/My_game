package com.company.screen;

import com.company.handler.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class Display  {
    private  static JFrame window;
    private static Canvas content;
    public static BufferStrategy bs;
    public static KeyHandler keyHandler;

    public Display(String GAME_NAME , int WIDTH, int HEIDHT, GeneralMenu generalMenu) {
        window = new JFrame(GAME_NAME);
        content = generalMenu;
        Dimension size = new Dimension(WIDTH, HEIDHT);
        content.setPreferredSize(size);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        content.createBufferStrategy(3);
        bs = content.getBufferStrategy();
    }

    public static void setHandler(KeyHandler k){
        keyHandler=k;
        content.addKeyListener(keyHandler);
    }
    public static void delHandler(){
        content.removeKeyListener(keyHandler);
    }
}
