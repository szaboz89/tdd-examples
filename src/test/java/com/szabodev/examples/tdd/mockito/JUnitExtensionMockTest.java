package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class JUnitExtensionMockTest {

    @Mock
    Map<String, Object> myMap;

    @Test
    void testMock() {
        myMap.put("key", "value");
    }
}
