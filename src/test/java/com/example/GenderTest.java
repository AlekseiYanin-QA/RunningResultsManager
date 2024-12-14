package com.example;

import org.example.Gender;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void testOfValidCode() {
        Gender gender = Gender.of("M");
        assertEquals(Gender.MALE, gender);
    }

    @Test
    void testOfInvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> Gender.of("X"));
    }
}
