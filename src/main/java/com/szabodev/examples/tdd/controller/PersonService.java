package com.szabodev.examples.tdd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PersonService {

    private Map<String, Person> persons = new HashMap<>();

    void save(Person p) {
        persons.put(p.getEmail(), p);
    }

    List<Person> findAll() {
        return new ArrayList<>(persons.values());
    }
}
