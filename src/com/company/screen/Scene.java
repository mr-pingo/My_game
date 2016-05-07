package com.company.screen;

import java.awt.image.BufferStrategy;

/**
 * Created by Ilya Malinovskiy on 26.04.2016.
 */
public interface Scene {
    void startMenu();
    void stop();
    void render(BufferStrategy bs);
    void update(long delta);
}
