package com.cannongame;

import java.awt.Color;

public class MovableBall extends PaintableBall{
    private int dx;
    private int dy;
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
        this.moveTo(x+getDx(), y+getDy());
    }

    public void moveTo(int x, int y) {
        super.setX(x);
        super.setY(y);
    }

}
