package com.cannongame;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main extends JFrame {
    static final int MIN_X = 0;
    static final int MAX_X = 400;
    static final int MIN_Y = 0;
    static final int MAX_Y = 300;
    static final int MIN_RADIUS = 10;
    static final int MAX_RADIUS = 50;
    static final int COUNT = 10;
    static final Color[] colors =
            {Color.BLUE, Color.RED, Color.white, Color.BLACK, Color.green};
    

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        Main frame = new Main();
        World world = new World();
        Random random = new Random();

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        world.setSize(400,300);
        frame.add(world);
        
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(world.getWidth());
            int y = random.nextInt(world.getHeight());
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS);
            Color color = colors[random.nextInt(colors.length)];
            try {
                world.add(new PaintableBall(x, y, radius, color));
            } catch (IllegalArgumentException e) {
                logger.warn(e.getMessage());
            }
        }
        frame.setVisible(true);
        frame.setEnabled(true);

    }

   
}
