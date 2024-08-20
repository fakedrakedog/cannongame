package com.cannongame;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Triangle extends Region {
    private String id = UUID.randomUUID().toString();
    private String name = id;
    private Logger logger;

    public Triangle(Point location, int width, int height) {
        super(location, width, height);
        if (((location.getX() - width / 2) > location.getX())
                || ((location.getX() + width / 2 < location.getX()))
                || (location.getY() - height / 2 > location.getY())
                || (location.getY() + height / 2 < location.getY())) {
            throw new IllegalArgumentException();
        }
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
        return logger;
    }

}
