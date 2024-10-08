// package com.cannongame;

// import static org.junit.Assert.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertAll;
// import java.awt.Color;
// import java.util.Map;
// import java.util.Random;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.RepetitionInfo;
// import org.junit.jupiter.api.TestInfo;

// public class PaintableBallTest {
// static final int MIN_X = 0;
// static final int MAX_X = 1000;
// static final int MIN_Y = 0;
// static final int MAX_Y = 1000;
// static final int MIN_RADIUS = 10;
// static final int MAX_RADIUS = 100;
// static final int TEST_COUNT = 10;
// static final Color[] colors = {Color.BLUE, Color.RED, Color.white, Color.BLACK, Color.green};

// Random random = new Random();
// DummyGraphics graphics = new DummyGraphics();

// @RepeatedTest(10)
// void testColorBall(RepetitionInfo repetitionInfo, TestInfo testInfo) {
// int x = MIN_X + random.nextInt(MAX_X - MIN_X);
// int y = MIN_Y + random.nextInt(MAX_Y - MIN_Y);
// int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS);
// Color baseColor = colors[random.nextInt(colors.length)];
// Color color = colors[random.nextInt(colors.length)];

// graphics.setColor(baseColor);
// PaintableBall ball = new PaintableBall(x, y, radius, color);
// ball.paint(graphics);
// Map<String, Object> fillOvalParams = graphics.getFillOvalParams();
// System.out.println("fill oval params: " + fillOvalParams);
// assertAll(testInfo.getDisplayName() + "-paint",
// () -> assertEquals((x - radius), graphics.getFillOvalParams().get("x")),
// () -> assertEquals((y - radius), graphics.getFillOvalParams().get("y")),
// () -> assertEquals((2 * radius), graphics.getFillOvalParams().get("width")),
// () -> assertEquals((2 * radius), graphics.getFillOvalParams().get("height")),
// () -> assertEquals(color, graphics.getFillOvalParams().get("color")),
// () -> assertEquals(baseColor, graphics.getColor()));
// }

// }
