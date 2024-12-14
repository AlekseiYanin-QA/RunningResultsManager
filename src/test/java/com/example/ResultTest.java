package com.example;

import org.example.Distance;
import org.example.Gender;
import org.example.Person;
import org.example.Result;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testHasGender() {
        Person person = new Person("Иван Иванов", Gender.MALE);
        Result result = new Result(person, Distance.TEN_KM, Duration.ofMinutes(15).plusSeconds(50));

        assertTrue(result.hasGender(Gender.MALE));
        assertFalse(result.hasGender(Gender.FEMALE));
    }

    @Test
    void testHasDistance() {
        Person person = new Person("Иван Иванов", Gender.MALE);
        Result result = new Result(person, Distance.TEN_KM, Duration.ofMinutes(15).plusSeconds(50));

        assertTrue(result.hasDistance(Distance.TEN_KM));
        assertFalse(result.hasDistance(Distance.FIVE_KM));
    }

    @Test
    void testGetValueReturnsNull() {
        Result result = new Result(null, null, null);
        assertNull(result.getValue(), "getValue should return null");
    }
}
