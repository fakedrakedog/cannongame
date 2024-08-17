package com.cannongame;

import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box {
    String id = UUID.randomUUID().toString();
    String name = id;
    Region region;
    Logger logger;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Box(Point location, int width, int height) {
        if ((width <= 0) || (height <= 0) || ((location.getX() - width / 2.0) > location.getX())
                || ((location.getX() + width / 2.0) < location.getX())
                || ((location.getY() - height / 2.0) > location.getY())
                || ((location.getY() + height / 2.0) < location.getY())) {
            throw new IllegalArgumentException();
        }
        region = new Region(location, width, height);
        logger = LogManager.getLogger(this.getClass());
    }

    public Region getRegion() {
        return this.region;
    }

    public Point getLocation() {
        return getRegion().getLocation();
    }

    public void setLocation(Point location) {
        region.moveTo(location);
    }

    public int getRadius() {
        return (getRegion().getWidth() / 2);
    }

    public int getWidth() {
        return getRegion().getWidth();
    }

    public int getHeight() {
        return getRegion().getHeight();
    }

    public boolean isCollision(Box other) {
        return getRegion().intersects(other.getRegion());
    }

    public Logger getLogger() {
        return logger;
    }
}
