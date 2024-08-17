package com.cannongame;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {
    private Rectangle bounds;

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);

        bounds = new Rectangle(x - radius, y - radius, x + radius, y + radius);
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        bounds = new Rectangle(x - radius, y - radius, x + radius, y + radius);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        return (getX() - getRadius() < bounds.getMinX())
                || (getX() + getRadius() > bounds.getMaxX())
                || (getY() - getRadius() < bounds.getMinY())
                || (getY() + getRadius() > bounds.getMaxY());
    }

    public void bounce() {
        if (getX() - getRadius() < bounds.getMinX()) {
            moveTo((int) bounds.getMinX() + getRadius(), getY());
            setDx(-getDx());

        } else if (getX() + getRadius() > bounds.getMaxX()) {
            moveTo((int) bounds.getMaxX() - getRadius(), getY());
            setDx(-getDx());
        }

        if (getY() - getRadius() < bounds.getMinY()) {
            moveTo(getX(), (int) bounds.getMinY() + getRadius());
            setDy(-getDy());
        } else if (getY() + getRadius() > bounds.getMaxY()) {
            moveTo(getX(), (int) bounds.getMaxY() - getRadius());
            setDy(-getDy());
        }
    }

    @Override
    public void move() {
        super.move();
        if (isOutOfBounds()) {
            bounce();
        }
    }

}
