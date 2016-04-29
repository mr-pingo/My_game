package com.company.handler;


import com.company.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Ilya Malinovskiy on 26.04.2016.
 */
public class MouseHandler implements MouseListener {

    @Override
    public void mousePressed(MouseEvent e) {
        Main.menu.startGame();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
