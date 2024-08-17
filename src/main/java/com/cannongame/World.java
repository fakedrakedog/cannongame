package com.cannongame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    private List<Ball> ballList = new LinkedList<>();
    private List<Box> boxList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Ball newBall) {
        if (newBall == null) {
            throw new IllegalArgumentException();
        }

        for (Ball ball : ballList) {
            if (newBall.isCollision(ball)) {
                throw new IllegalArgumentException();
            }
        }

        if ((newBall.getRegion().getMinX() < 0) || (getWidth() < newBall.getRegion().getMaxX())
                || (newBall.getRegion().getMinY() < 0)
                || (getHeight() < newBall.getRegion().getMaxY())) {
            throw new IllegalArgumentException("추가하려는 newBall이 world를 벗어납니다.");
        }

        ballList.add(newBall);

    }


    public void remove(Ball ball) {
        if (!ballList.contains(ball)) {
            throw new NoSuchElementException("존재 하지 않는 ball");
        }
        ballList.remove(ball);
    }

    public void remove(int index) {
        if (index < 0 || index >= ballList.size()) {
            throw new IndexOutOfBoundsException("index out");
        }
        ballList.remove(index);
    }

    public Ball get(int index) {
        if (index < 0 || index >= ballList.size()) {
            throw new IndexOutOfBoundsException("index out");
        }
        return ballList.get(index);
    }

    public int getCount() {
        return ballList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.red);
        for (int i = 0; i < getCount(); i++) {
            Ball ball1 = get(i);
            for (int j = i + 1; j < getCount(); j++) {
                Ball ball2 = get(j);

                if (ball1.isCollision(ball2)) {
                    Region collisionArea = ball1.getRegion().intersection(ball2.getRegion());

                    g.drawRect((int) collisionArea.getMinX(), (int) collisionArea.getMinY(),
                            (int) collisionArea.getWidth(), (int) collisionArea.getHeight());
                }
            }
        }
        g.setColor(previousColor);
    }


}
