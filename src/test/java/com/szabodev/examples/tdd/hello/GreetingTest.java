package com.szabodev.examples.tdd.hello;

import org.junit.jupiter.api.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    static void beforeClass() {
        System.out.println("BeforeAll - beforeClass");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach - setUp");
        greeting = new Greeting();
    }

    @Test
    void hello() {
        System.out.println("hello");
        Assertions.assertEquals("Hello World", greeting.hello());
    }

    @Test
    void testHello() {
        System.out.println("testHello");
        Assertions.assertEquals("Hello John", greeting.hello("John"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach - tearDown");
    }

    @AfterAll
    static void afterClass() {
        System.out.println("AfterAll - afterClass");
    }
}
