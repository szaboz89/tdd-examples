package com.szabodev.examples.tdd;

import com.szabodev.examples.tdd.fizzbuzz.FizzBuzz;
import com.szabodev.examples.tdd.hello.Greeting;
import com.szabodev.examples.tdd.mylist.CustomList;

public class Main {

    public static void main(String[] args) {
        usingFizzBuzz(1, 2, 3, 5, 6, 10, 15, 30);
        testCustomList();
        testGreeting();
    }

    private static void testGreeting() {
        Greeting greeting = new Greeting();
        System.out.println(greeting.hello());
        System.out.println(greeting.hello("Test"));
    }

    private static void testCustomList() {
        CustomList<String> customList = new CustomList<>();
        customList.add("Test");
        System.out.println(customList.get(0));
    }

    private static void usingFizzBuzz(int... args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.execute(args));
    }
}
