package com.cannongame;

import java.awt.Color;

public class MovableBall extends PaintableBall implements Movable {
    Motion motion = Motion.createPosition(0, 0);

    public MovableBall(Point location, int radius) {
        super(location, radius);
    }

    public MovableBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    public void move() {
        move(getMotion());
    }

    @Override
    public Motion getMotion() {
        return motion;
    }

    @Override
    public void setMotion(Motion motion) {
        this.motion = motion;
    }

    public void addEffect(Motion effect) {
        motion.add(effect);
    }

}
