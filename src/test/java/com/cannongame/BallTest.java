package com.cannongame;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import java.util.Random;
import org.junit.jupiter.api.Test;

class BallTest {

    static Random random = new Random();
    int loopCount = 100;

    @Test
    void testConstructionWithArgument() {
        for (int i = 0; i < loopCount; i++) {
            int radius = random.nextInt(Integer.MAX_VALUE);
            int x = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(3) - 1);
            int y = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(3) - 1);

            assertDoesNotThrow(() -> {
                Ball ball = new Ball(x, y, radius);
                assertEquals(x, ball.getX());
                assertEquals(y, ball.getY());
                assertEquals(radius, ball.getRadius());
            });
        }
    }

    @Test
    void testConstructionWithIllegalArgument() {
        for (int i = 0; i < loopCount; i++) {
            int illegalCase = random.nextInt(3);
            int radius = random.nextInt(Integer.MAX_VALUE);
            int x;
            int y;

            if ((illegalCase == 1) || (illegalCase == 3)) {
                x = (Integer.MAX_VALUE - random.nextInt(radius))
                        * (random.nextInt(1) == 0 ? 1 : -1);
            } else {
                x = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(1) == 0 ? 1 : -1);
            }

            if ((illegalCase == 2) || (illegalCase == 3)) {
                y = (Integer.MAX_VALUE - random.nextInt(radius))
                        * (random.nextInt(1) == 0 ? 1 : -1);
            } else {
                y = random.nextInt(Integer.MAX_VALUE - radius) * (random.nextInt(1) == 0 ? 1 : -1);
            }

            if (illegalCase == 0) {
                radius = random.nextInt(Integer.MAX_VALUE) * -1;
            }

            int r = radius;
            assertThrowsExactly(IllegalArgumentException.class, () -> new Ball(x, y, r));
        }

    }


}
