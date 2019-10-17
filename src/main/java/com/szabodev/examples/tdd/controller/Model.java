package com.szabodev.examples.tdd.controller;

public interface Model {

    void addAttribute(String key, Object o);

    Object getValue(String key);
}
