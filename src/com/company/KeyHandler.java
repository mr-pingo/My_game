package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Малиновский Илья on 09.03.2016.
 */
public class KeyHandler extends KeyAdapter {

    public boolean isLeftpressent() {
        return leftpressent;
    }

    public boolean isRightpressent() {
        return rightpressent;
    }

    public boolean isSpacepressent() {
        return spacepressent;
    }

    public void setSpacepressent(boolean spacepressent) {
        this.spacepressent = spacepressent;
    }

    private boolean leftpressent =false;
    private boolean rightpressent =false;


    private boolean spacepressent = false;

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            leftpressent=true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightpressent=true;
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            spacepressent=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            leftpressent=false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightpressent=false;
    }
}

