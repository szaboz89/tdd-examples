package com.szabodev.examples.tdd.assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner("first", "last", "email");
        owner.setCity("city");
        owner.setPhone("phone");
    }

    @DisplayName("Example for grouping assertions")
    @Test
    void assertAllTest() {
        assertAll("Owner properties",
                () -> assertAll("Parent properties",
                        () -> assertEquals("first", owner.getFirstName()),
                        () -> assertEquals("last", owner.getLastName()),
                        () -> assertEquals("email", owner.getEmail())
                ),
                () -> assertAll("Owner properties",
                        () -> assertEquals("city", owner.getCity()),
                        () -> assertEquals("phone", owner.getPhone())
                )
        );
    }
}
