package com.szabodev.examples.tdd.assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
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

    @Test
    void assertWithAssertJ() {
        assertThat(person.getFirstName()).isEqualTo("first");
    }

    @Test
    void assertWithHamcrest() {
        org.hamcrest.MatcherAssert.assertThat(person.getLastName(), is("last"));
    }
}
