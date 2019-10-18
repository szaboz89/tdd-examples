package com.szabodev.examples.tdd.params;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class ParamsExampleTest {

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource2(String val) {
        System.out.println(val);
    }

    @ParameterizedTest
    @EnumSource(EnumExample.class)
    void enumTest(EnumExample enumExample) {
        System.out.println(enumExample);
    }

    @ParameterizedTest
    @CsvSource({
            "AA, 1, 1",
            "BB, 2, 2",
            "CC, 3, 3"
    })
    void csvInputTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + ":" + value2);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String state, int value1, int value2) {
        System.out.println(state + " = " + value1 + ":" + value2);
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void paramsFromMethod(String state, int value1, int value2) {
        System.out.println(state + " = " + value1 + ":" + value2);
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("AA", 1, 1),
                Arguments.of("BB", 2, 2),
                Arguments.of("CC", 4, 3));
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void paramsFromCustomProvider(String state, int value1, int value2) {
        System.out.println(state + " = " + value1 + ":" + value2);
    }
}
