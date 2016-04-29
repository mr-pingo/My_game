package com.company.object.platform;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ??????????? ???? on 12.03.2016.
 */
public abstract class Platform {

    public static ArrayList<Platform> addPlatforms(){
        ArrayList<Platform> platforms = new ArrayList<>();
        platforms.add(new LongPlatform(232,404));
        platforms.add(new ShortPlatform(467,315));
        platforms.add(new LongPlatform(516,207));
        platforms.add(new MovePlatformX(300,144));
        platforms.add(new ShortPlatform(85,67));
        platforms.add(new ShortPlatform(22,251));
        platforms.add(new ShortPlatform(801,114));
        platforms.add(new MovePlatformY(995,174));
        platforms.add(new ShortPlatform(875,314));
        platforms.add(new ShortPlatform(1129,66));
        return platforms;
    }
    public abstract int getHEIGHT();

    public abstract int getWIDTH();

    public abstract int getX();

    public abstract int getY();

    public abstract void drawImage(Graphics g);

    public static void render(Graphics g,ArrayList<Platform> platforms){  //???? foreach ??? ??????????? ?? ?????????
        for (Platform platform1 :platforms) {
            platform1.drawImage(g);
        }

    }

}
