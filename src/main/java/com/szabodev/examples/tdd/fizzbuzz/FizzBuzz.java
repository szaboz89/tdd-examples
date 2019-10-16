package com.szabodev.examples.tdd.fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {

    public String execute(List<Integer> numbers) {
        return numbers.stream()
                .map(this::processNumber)
                .collect(Collectors.joining(", "));
    }

    String processNumber(Integer number) {
        if (isMultipleOf3(number) && isMultipleOf5(number)) {
            return "FizzBuzz";
        }

        if (isMultipleOf3(number)) {
            return "Fizz";
        }

        if (isMultipleOf5(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
