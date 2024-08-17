package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box {
    private Color color;
    static final Color DEFAULT_COLOR = Color.black;

    public PaintableBox(Point location, int width, int height) {
        super(location, width, height);
        this.color = DEFAULT_COLOR;
    }

    public PaintableBox(Point location, int width, int height, Color color) {
        super(location, width, height);
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
        g.fillRect(getRegion().getMinX(), getRegion().getMinY(), getRegion().getWidth(),
                getRegion().getHeight());
        g.setColor(previousColor);
    }


}
