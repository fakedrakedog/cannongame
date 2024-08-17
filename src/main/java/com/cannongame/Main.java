package com.cannongame;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main extends JFrame {
    static final int WORLD_WIDTH = 400;
    static final int WORLD_HEIGHT = 300;
    static final int MIN_RADIUS = 10;
    static final int MAX_RADIUS = 50;
    static final int MIN_DELTA = 10;
    static final int MAX_DELTA = 30;
    static final int BALL_COUNT = 2;
    static final int MAX_MOVE_COUNT = 100;
    static final int DELTA_TIME = 100;
    static Logger logger = LogManager.getLogger("main");

    public static void main(String[] args) throws InterruptedException {

        Main frame = new Main();
        BoundedWorld world = new BoundedWorld();
        Random random = new Random();

        frame.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        world.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        frame.add(world);

        while (world.getCount() < BALL_COUNT) {
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            int x = radius + random.nextInt(WORLD_WIDTH - 2 * radius);
            int y = radius + random.nextInt(WORLD_HEIGHT - 2 * radius);
            MovableBall ball = new MovableBall(new Point(x, y), radius);
            int dx = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);
            int dy = MIN_DELTA + random.nextInt(MAX_DELTA - MIN_DELTA + 1);

            if (radius * 2 <= dx) {
                dx = radius;
            }

            if (radius * 2 <= dy) {
                dy = radius;
            }

            String sequence = "00" + (world.getCount() + 1);
            ball.setName("ball_" + sequence.substring(sequence.length() - 2));
            ball.setDX(dx);
            ball.setDY(dy);

            try {
                world.add(ball);
            } catch (IllegalArgumentException e) {
                logger.warn("요청하신 위치[{},{}]에 다른 볼이 있어 등록이 불가능합니다.", x, y);
            }
        }

        frame.setVisible(true);
        frame.setEnabled(true);

        world.setMaxMoveCount(MAX_MOVE_COUNT);
        world.setDT(DELTA_TIME);
        world.run();
    }


}
