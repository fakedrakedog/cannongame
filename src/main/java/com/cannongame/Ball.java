package com.cannongame;

import java.awt.Graphics;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    String id = UUID.randomUUID().toString();
    String name = id;

    int x;
    int y;
    int radius;
    Logger logger;


    public Ball(int x, int y, int radius) {
        if ((radius <= 0) || ((x >= 0) && ((Integer.MAX_VALUE - x) < radius))
                || ((x < 0) && ((x - Integer.MIN_VALUE) < radius))
                || ((y >= 0) && ((Integer.MAX_VALUE - y) < radius))
                || ((y < 0) && ((y - Integer.MIN_VALUE) < radius))) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.logger = LogManager.getLogger(this.getClass());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Logger getLogger() {
        return this.logger;
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
