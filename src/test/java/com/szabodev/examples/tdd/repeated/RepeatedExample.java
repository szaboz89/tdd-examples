package com.szabodev.examples.tdd.repeated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public interface RepeatedExample {

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
