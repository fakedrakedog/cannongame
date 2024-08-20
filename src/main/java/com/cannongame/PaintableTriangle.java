package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableTriangle extends Triangle implements Paintable {
    private Color color;
    private static final Color BASE_COLOR = Color.black;

    public PaintableTriangle(Point location, int width, int height) {
        this(location, width, height, BASE_COLOR);
    }

    public PaintableTriangle(Point location, int width, int height, Color color) {
        super(location, width, height);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void paint(Graphics g) {
        if (g == null) {
            throw new IllegalArgumentException("Graphics context g is null");
        }
        int[] xs = { getLocation().getX(), getMinX(), getMaxX() };
        int[] ys = { getMaxY(), getMinY(), getMinY() };

        Color previousColor = g.getColor();
        g.setColor(getColor());
        g.fillPolygon(xs, ys, xs.length);
        g.setColor(previousColor);
    }

}
