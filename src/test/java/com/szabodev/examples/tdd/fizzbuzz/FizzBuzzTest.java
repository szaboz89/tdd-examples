package com.szabodev.examples.tdd.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void shouldProcessInput() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals(fizzBuzz.processNumber(1), "1");
        assertEquals(fizzBuzz.processNumber(2), "2");
        assertEquals(fizzBuzz.processNumber(3), "Fizz");
        assertEquals(fizzBuzz.processNumber(5), "Buzz");
        assertEquals(fizzBuzz.processNumber(6), "Fizz");
        assertEquals(fizzBuzz.processNumber(10), "Buzz");
        assertEquals(fizzBuzz.processNumber(15), "FizzBuzz");
    }

    @Test
    void shouldExecute() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertEquals(fizzBuzz.execute(Collections.singletonList(1)), "1");
        assertEquals(
                fizzBuzz.execute(Arrays.asList(1, 2, 3, 5, 6, 10, 15, 30)),
                "1, 2, Fizz, Buzz, Fizz, Buzz, FizzBuzz, FizzBuzz"
        );
    }
}
