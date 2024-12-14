package com.example;

import org.example.Distance;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void testOfValidCode() {
        Distance distance = Distance.of("10 km");
        assertEquals(Distance.TEN_KM, distance);
    }

    @Test
    void testOfInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> Distance.of("15 km"));
    }
}
