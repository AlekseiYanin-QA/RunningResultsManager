package com.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

class ResultsProcessorTest {

    private ResultsProcessor processor;

    @BeforeEach
    void setUp() {
        List<Result> results = Arrays.asList(
                new Result(new Person("Иван Иванов", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(3600)),
                new Result(new Person("Анна Иванова", Gender.FEMALE), Distance.TEN_KM, Duration.ofSeconds(3700)),
                new Result(new Person("Петр Петров", Gender.MALE), Distance.FIVE_KM, Duration.ofSeconds(1500)));

        processor = new ResultsProcessor(results);
    }

    @Test
    void testGetFastestMaleTenKm() {
        List<Result> fastest = processor.getFastest(Gender.MALE, Distance.TEN_KM, 1);

        assertEquals(1, fastest.size());
        assertEquals("Иван Иванов", fastest.get(0).person().name());
    }

    @Test
    void testGetFastestFemaleFiveKm() {
        List<Result> fastest = processor.getFastest(Gender.FEMALE, Distance.FIVE_KM, 1);

        assertTrue(fastest.isEmpty());
    }

    @Test
    void testGetFastestAllLimit() {
        List<Result> fastest = processor.getFastest(Gender.MALE, Distance.TEN_KM, 2);

        assertEquals(1, fastest.size());
        assertEquals("Иван Иванов", fastest.get(0).person().name());
    }
}
