package com.szabodev.examples.tdd.assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("first", "last", "email");
    }

    @Test
    void assertAllTest() {
        assertAll("Person properties",
                () -> assertEquals("first", person.getFirstName()),
                () -> assertEquals("last", person.getLastName()),
                () -> assertEquals("email", person.getEmail())
        );
    }
}
