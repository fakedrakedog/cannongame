package com.cannongame;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel{
    private List<Ball> ballList = new LinkedList<>();
    Logger logger = LogManager.getLogger(); 
    public World() {
        super();
    }

    public void add(Ball ball) {
       if (ball == null) {
            throw new IllegalArgumentException();
        }

        if ((ball.getX() - ball.getRadius() < 0)
                || (getWidth() < ball.getX() + ball.getRadius())
                || (ball.getY() - ball.getRadius() < 0)
                || (getHeight() < ball.getY() + ball.getRadius())) {
            throw new IllegalArgumentException("추가하려는 ball이 world를 벗어납니다.");
        }

        ballList.add(ball);
        if (ball instanceof PaintableBall) {
            logger.trace(String.format("ball 추가 : %4d, %4d, %4d, %s",
                    ((PaintableBall) ball).getX(),
                    ((PaintableBall) ball).getY(),
                    ((PaintableBall) ball).getRadius(),
                    ((PaintableBall) ball).getColor().toString()));
        }
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Ball ball : ballList){
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }
    }
    

    
}
