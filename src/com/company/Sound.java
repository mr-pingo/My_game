package com.company;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ilya Malinovskiy on 27.03.2016.
 */
public class Sound {
    private Clip clip= null;
    private boolean playing=false;

    public Sound(File file) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip =AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }
    public void play(){
        clip.setFramePosition(0);
        clip.start();
        playing=true;
    }

    public void stop(){
        clip.stop();
        playing=false;
    }
}
