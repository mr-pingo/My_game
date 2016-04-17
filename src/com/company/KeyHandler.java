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

    public boolean isUppressent() {
        return uppressent;
    }

    public boolean isDownpressent() {
        return downpressent;
    }

    private boolean leftpressent =false;
    private boolean rightpressent =false;
    private boolean spacepressent = false;
    private boolean uppressent = false;
    private boolean downpressent = false;

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            leftpressent=true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightpressent=true;
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            spacepressent=true;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            uppressent=true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            downpressent=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            leftpressent=false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            rightpressent=false;
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            spacepressent=false;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            uppressent=false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            downpressent=false;
    }
}

