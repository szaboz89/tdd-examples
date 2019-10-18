package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class InlineMockTest {

    @Test
    void testInlineMock() {
        Map myMap = mock(Map.class);
        assertEquals(0, myMap.size());
    }
}
