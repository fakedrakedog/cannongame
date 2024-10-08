package com.cannongame;

import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball extends Region {
    private String id = UUID.randomUUID().toString();
    private String name = id;
    private Logger logger;

    public Ball(Point location, int radius) {
        super(location, 2 * radius, 2 * radius);
        if (((location.getX() - radius) > location.getX())
                || ((location.getX() + radius) < location.getX())
                || ((location.getY() - radius) > location.getY())
                || ((location.getY() + radius) < location.getY())) {
            throw new IllegalArgumentException();
        }
        this.logger = LogManager.getLogger(this.getClass());
    }

    public int getRadius() {
        return (getWidth() / 2);
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

}
