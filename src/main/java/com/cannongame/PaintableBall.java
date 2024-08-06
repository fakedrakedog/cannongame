package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball{
    private Color color;

    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void paint(Graphics g) {
        if (g == null) {
            throw new IllegalArgumentException("Graphics context g is null");
        }

        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.drawOval(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
        g.setColor(previousColor);
    }

    
}
