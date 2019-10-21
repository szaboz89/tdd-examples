package com.szabodev.examples.tdd.fakespring;

public interface Model {

    void addAttribute(String key, Object o);

    Object getValue(String key);
}
