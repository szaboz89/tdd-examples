package com.szabodev.examples.tdd.assertions.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SkipTest2 {

    @Test
    void testException() {
        Skip skip = new Skip();
        Assertions.assertThrows(RuntimeException.class, skip::skipMethod);
    }
}
