package com.szabodev.examples.tdd.hello;

public class Greeting {

    private static final String HELLO = "Hello";
    private static final String WORLD = "World";

    public String hello() {
        return HELLO + " " + WORLD;
    }

    public String hello(String name) {
        return HELLO + " " + name;
    }
}
