package com.cannongame;

import java.awt.Color;

public class MovableTriangle extends PaintableTriangle implements Movable {
    Motion motion = Motion.createPosition(0, 0);

    public MovableTriangle(Point location, int width, int height) {
        super(location, width, height);
    }

    public MovableTriangle(Point location, int width, int height, Color color) {
        super(location, width, height, color);
    }

    @Override
    public Motion getMotion() {
        return motion;
    }

    @Override
    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public void move() {
        move(getMotion());
    }

    @Override
    public void addEffect(Motion effect) {
        motion.add(effect);
    }

}
