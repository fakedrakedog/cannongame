package com.cannongame.old;

public class Point {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        moveTo(other);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Point other) {
        x = other.getX();
        y = other.getY();
    }

    public void translate(int dx, int dy) {
        moveTo(getX() + dx, getY() + dy);
    }

    public void move(Motion motion) {
        moveTo(getX() + motion.getDX(), getY() + motion.getDY());
    }

    public void moveTo(int x, int y) {
        set(x, y);
    }

    public void moveTo(Point other) {
        set(other);
    }

    public static int distance(Point point1, Point point2) {
        return (int) Math.sqrt(Math.pow((double) point1.getX() - point2.getX(), 2)
                + Math.pow((double) point1.getY() - point2.getY(), 2));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}
