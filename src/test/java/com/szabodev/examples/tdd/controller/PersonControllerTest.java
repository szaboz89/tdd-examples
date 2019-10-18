package com.szabodev.examples.tdd.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PersonControllerTest implements ControllerTests {

    private PersonController personController;

    @BeforeEach
    void setUp() {
        PersonService personService = new PersonService();
        personService.save(new Person("first", "last", "email"));
        personService.save(new Person("john", "doe", "email2"));
        personController = new PersonController(personService);
    }

    @Test
    void personList() {
        Model model = new MyModel();

        String view = personController.personList(model);
        assertThat("personsView").isEqualTo(view);

        @SuppressWarnings("unchecked")
        List<Person> modelAttribute = (List<Person>) model.getValue("persons");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }

    private static class MyModel implements Model {
        Map<String, Object> map = new HashMap<>();

        @Override
        public void addAttribute(String key, Object o) {
            map.put(key, o);
        }

        @Override
        public Object getValue(String key) {
            return map.get(key);
        }
    }
}
