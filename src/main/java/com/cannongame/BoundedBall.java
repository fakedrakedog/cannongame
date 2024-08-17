package com.cannongame;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {
    private Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        bounds = new Rectangle(x - radius, y - radius, x + radius, y + radius);
    }

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);
        bounds = new Rectangle(x - radius, y - radius, x + radius, y + radius);
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public boolean isOutOfBounds() {
        return (getX() - getRadius() < bounds.getMinX() || getX() + getRadius() > bounds.getMaxX()
                || getY() - getRadius() < bounds.getMinY()
                || getY() + getRadius() > bounds.getMaxY());
    }

    public void move() {
        super.move();
        if (isOutOfBounds()) {
            bounce();
        }
    }

    public void bounce() {
        if (getX() - getRadius() < bounds.getMinX() || getX() + getRadius() > bounds.getMaxX()) {
            setDx(-getDx());
        }
        if (getY() - getRadius() < bounds.getMinY() || getY() + getRadius() > bounds.getMaxY()) {
            setDy(-getDy());

        }
    }


}
