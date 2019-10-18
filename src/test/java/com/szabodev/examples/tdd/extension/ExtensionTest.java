package com.szabodev.examples.tdd.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
class ExtensionTest {

    @Test
    void testMethod() {
    }
}
