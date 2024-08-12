package com.cannongame;

import java.awt.Color;

public class MovableBall extends PaintableBall{
    private int dx = 0;
    private int dy = 0;

    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }
    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }
    public int getDx() {
        return dx;
    }
    
    public int getDy() {
        return dy;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
    public void move() {
        moveTo(getX() + getDx(), getY() + getDy());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
        getLogger().trace(getName() + " move to : x = " + getX() + ", y = " + getY());
        
    }

}
