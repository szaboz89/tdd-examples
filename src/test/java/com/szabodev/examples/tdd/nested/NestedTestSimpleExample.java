package com.szabodev.examples.tdd.nested;

import org.junit.jupiter.api.*;

class NestedTestSimpleExample {

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("@BeforeAll - Outer Class");
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("@AfterAll - Outer Class");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach - Outer Class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Outer Class");
    }

    @Test
    void test() {
        System.out.println("Outer Class Test");
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    @Nested
    class InnerClass {
        @BeforeEach
        void setUp() {
            System.out.println("@BeforeEach - Inner Class");
        }

        @AfterEach
        void tearDown() {
            System.out.println("@AfterEach - Inner Class");
        }

        @Test
        void test() {
            System.out.println("Inner Class Test");
        }
    }
}
