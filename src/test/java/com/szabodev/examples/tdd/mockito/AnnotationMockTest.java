package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

class AnnotationMockTest {

    @Mock
    Map<String, Object> myMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMock() {
        myMap.put("key", "value");
    }
}
