package com.cannongame.old;

import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    private String id = UUID.randomUUID().toString();
    private String name = id;
    private Point location;
    private Region region;
    private Logger logger;

    public Ball(Point location, int radius) {
        if ((radius <= 0)
                || ((location.getX() >= 0) && ((Integer.MAX_VALUE - location.getX()) < radius))
                || ((location.getX() < 0) && ((location.getX() - Integer.MIN_VALUE) < radius))
                || ((location.getY() >= 0) && ((Integer.MAX_VALUE - location.getY()) < radius))
                || ((location.getY() < 0) && ((location.getY() - Integer.MIN_VALUE) < radius))) {
            throw new IllegalArgumentException();
        }
        region = new Region(location, 2 * radius, 2 * radius);
        this.logger = LogManager.getLogger(this.getClass());
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }

    public int getRadius() {
        return (getRegion().getWidth() / 2);
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

    public Region getRegion() {
        return region;
    }

    public boolean isCollision(Ball other) {
        return getRegion().intersects(other.getRegion());

    }

}
