package com.cannongame;

import static org.junit.Assert.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BoxTest {
    @ParameterizedTest
    @MethodSource("boxConstructionProvider")
    void testBoxConstructor(int x, int y, int width, int height) {
        Box box = new Box(new Point(x, y), width, height);
        assertEquals(x, box.getLocation().getX());
        assertEquals(y, box.getLocation().getY());
        assertEquals(width, box.getWidth());
        assertEquals(height, box.getHeight());
    }

    static Stream<Arguments> boxConstructionProvider() {
        return Stream.of(Arguments.arguments(0, 0, 20, 20), Arguments.arguments(0, 20, 20, 20),
                Arguments.arguments(20, 0, 20, 20), Arguments.arguments(20, 20, 20, 20),
                Arguments.arguments(0, 0, 20, 20), Arguments.arguments(0, -20, 20, 20),
                Arguments.arguments(-20, 0, 20, 20), Arguments.arguments(-20, -20, 20, 20));
    }
}
