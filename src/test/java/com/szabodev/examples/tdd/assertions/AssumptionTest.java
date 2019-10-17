package com.szabodev.examples.tdd.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AssumptionTest {

    @Test
    void testAssumptionTrue() {
        assumeTrue("TEST".equalsIgnoreCase(System.getenv("TEST")));
        System.out.println("Test will be skipped");
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        //noinspection EqualsWithItself
        assumeTrue("test".equalsIgnoreCase("test"));
        System.out.println("Test continues");
    }
}
