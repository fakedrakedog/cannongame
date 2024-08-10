package com.cannongame;

import java.awt.Graphics;

public class Ball {
    int x;
    int y;
    int radius;


    /**
     * Constructor.
     *
     * @param x      X축 좌표
     * @param y      Y축 좌표
     * @param radius 반지름
     */
    public Ball(int x, int y, int radius) {
        if ((radius <= 0)
                || ((x >= 0) && ((Integer.MAX_VALUE - x) < radius))
                || ((x < 0) && ((x - Integer.MIN_VALUE) < radius))
                || ((y >= 0) && ((Integer.MAX_VALUE - y) < radius))
                || ((y < 0) && ((y - Integer.MIN_VALUE) < radius))) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void paint(Graphics g) {
        g.drawOval(x, y, radius, radius);
    }

}
