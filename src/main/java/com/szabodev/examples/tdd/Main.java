package com.szabodev.examples.tdd;

import com.szabodev.examples.tdd.fizzbuzz.FizzBuzz;

public class Main {

    public static void main(String[] args) {
        usingFizzBuzz(1, 2, 3, 5, 6, 10, 15, 30);
    }

    private static void usingFizzBuzz(int... args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.execute(args));
    }
}
