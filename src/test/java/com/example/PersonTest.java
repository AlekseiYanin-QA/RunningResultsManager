package com.example;

import org.example.Gender;
import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testConstructor() {
        Person person = new Person("Иван Иванов", Gender.MALE);

        assertEquals("Иван Иванов", person.name());
        assertEquals(Gender.MALE, person.gender());
    }
}
