package com.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ResultParserTest {

    private ResultParser parser;

    @BeforeEach
    void setUp() {
        parser = new ResultParser();
    }

    @Test
    void testParseResult() {
        String line = "Иван Иванов,M,10 km,55:20";
        Result result = parser.parseResult(line);

        assertNotNull(result);
        assertEquals(new Person("Иван Иванов", Gender.MALE), result.person());
        assertEquals(Duration.ofSeconds(3320), result.time());
        assertEquals(Distance.TEN_KM, result.distance());
    }

    @Test
    void testParseInvalidLine() {
        String invalidLine = "Иван Иванов,M,10 km,invalid_time";
        assertThrows(IllegalArgumentException.class, () -> parser.parseResult(invalidLine));
    }

    @Test

    void testParseTime() {
        String validTime = "01:23";

        Method parseTimeMethod;
        try {
            parseTimeMethod = ResultParser.class.getDeclaredMethod("parseTime", String.class);
            parseTimeMethod.setAccessible(true);
            Duration duration = (Duration) parseTimeMethod.invoke(parser, validTime);
            assertEquals(Duration.ofSeconds(83), duration);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            fail("Не удалось вызвать метод parseTime через рефлексию.");
        }

        String invalidTime = "invalid_time";
        assertThrows(NumberFormatException.class, () -> parser.parseTime(invalidTime));
    }
}
