package com.company.screen;

import com.company.handler.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;


public class Display  {
    private  static JFrame window;
    private static Canvas content;
    public static BufferStrategy bs;

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
        content.addKeyListener(k);
    }
    public static void delHandler(KeyHandler k){
        content.removeKeyListener(k);
    }

    public static void setMouseListener(MouseListener ml){
        content.addMouseListener(ml);
    }

    public static void setMouseListener(MouseListener ml, MouseMotionListener mml){
        content.addMouseListener(ml);
        content.addMouseMotionListener(mml);
    }

    public static void delMouseListener(MouseListener ml){
        content.removeMouseListener(ml);
    }

    public static void delMouseListener(MouseListener ml, MouseMotionListener mml){
        content.removeMouseListener(ml);
        content.removeMouseMotionListener(mml);
    }
}
