package com.szabodev.examples.tdd;

import com.szabodev.examples.tdd.fizzbuzz.FizzBuzz;
import com.szabodev.examples.tdd.hello.Greeting;
import com.szabodev.examples.tdd.money.Bank;
import com.szabodev.examples.tdd.money.Money;
import com.szabodev.examples.tdd.mylist.CustomList;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testFizzBuzz();
        testCustomList();
        testGreeting();
        testMoney();
    }

    private static void testMoney() {
        System.out.println("Money example");
        Money dollar5 = Money.dollar(5);
        Money franc5 = Money.franc(5);
        System.out.println("5 dollars multiplied with 2: " + dollar5.times(2));
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        bank.addRate("USD", "CHF", 0.5);
        System.out.println("5 frank plus 2 frank: " + bank.reduce(franc5.plus(Money.franc(2)), "CHF"));
        System.out.println("4 frank plus 4 dollar in usd: " + bank.reduce(Money.franc(4).plus(Money.dollar(4)), "USD"));
        System.out.println("4 frank plus 4 dollar in chf: " + bank.reduce(Money.franc(4).plus(Money.dollar(4)), "CHF"));
        System.out.println("============================");
    }

    private static void testGreeting() {
        System.out.println("Greeting example");
        Greeting greeting = new Greeting();
        System.out.println(greeting.hello());
        System.out.println(greeting.hello("Test"));
        System.out.println("============================");
    }

    private static void testCustomList() {
        System.out.println("CustomList example");
        CustomList<String> customList = new CustomList<>();
        customList.add("Test1");
        customList.add("Test2");
        System.out.println("Size: " + customList.size());
        System.out.println("First element: " + customList.get(0));
        System.out.println("============================");
    }

    private static void testFizzBuzz() {
        System.out.println("FizzBuzz example");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 6, 10, 15, 30);
        System.out.println("Numbers: " + numbers);
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println("Result: " + fizzBuzz.execute(numbers));
        System.out.println("============================");
    }
}
