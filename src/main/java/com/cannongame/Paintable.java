package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;

public interface Paintable {
    public Color getColor();

    public void paint(Graphics g);
}
