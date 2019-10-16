package com.szabodev.examples.tdd.assertions.skip;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class SkipTest {

    @Disabled
    @Test
    void firstTest() {
        Skip skip = new Skip();
        skip.skipMethod();
    }

    @Test
    void secondTest() {
    }
}
