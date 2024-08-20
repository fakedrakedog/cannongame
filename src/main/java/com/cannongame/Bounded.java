package com.cannongame;

public interface Bounded {
    public Regionable getBounds();

    public void setBounds(Regionable bounds);

    public boolean isOutOfBounds(Regionable bounds);

    public void bounce();
}
