package com.szabodev.examples.tdd.nested;

import org.junit.jupiter.api.*;

class NestedExampleTest {

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("@BeforeAll - Outer Class");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach - Outer Class");
    }

    @Test
    void outerTest() {
        System.out.println("Outer Class test method");
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class InnerClass {
        @BeforeAll
        void setUpBeforeClassInner() {
            System.out.println("@BeforeAll - Inner Class");
        }

        @BeforeEach
        void setUp() {
            System.out.println("@BeforeEach - Inner Class");
        }

        @Test
        void innerTest() {
            System.out.println("Inner Class test method");
        }

        @AfterEach
        void tearDown() {
            System.out.println("@AfterEach - Inner Class");
        }

        @AfterAll
        void tearDownAfterClassInner() {
            System.out.println("@AfterAll - Inner Class");
        }
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Outer Class");
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("@AfterAll - Outer Class");
    }
}
