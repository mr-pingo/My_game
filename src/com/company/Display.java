package com.company;

import javax.swing.*;
import java.awt.*;


public class Display  {
    private  static JFrame window;
    private static Canvas content;
    public static JLabel label= new JLabel("Score: 0");

    public Display(String GAME_NAME , int WIDTH, int HEIDHT, Game game){
        window = new JFrame(GAME_NAME);
        content = game;
        Dimension size = new Dimension(WIDTH, HEIDHT);
        content.setPreferredSize(size);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
    }


}
