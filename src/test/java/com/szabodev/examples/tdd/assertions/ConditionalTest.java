package com.szabodev.examples.tdd.assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "OS", matches = "Test")
    @Test
    void testIfOsTest() {
    }

    @EnabledIfEnvironmentVariable(named = "OS", matches = "Windows_NT")
    @Test
    void testIfOsWindowsNt() {
    }
}
