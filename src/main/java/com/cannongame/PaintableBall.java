package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball implements Paintable {
    private Color color;

    private static final Color BASE_COLOR = Color.black;

    public PaintableBall(Point location, int radius) {
        super(location, radius);
        this.color = BASE_COLOR;
    }

    public PaintableBall(Point location, int radius, Color color) {
        super(location, radius);
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
        g.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
        g.setColor(previousColor);
    }

}
