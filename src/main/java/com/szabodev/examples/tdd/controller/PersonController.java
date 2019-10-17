package com.szabodev.examples.tdd.controller;

class PersonController {

    private final PersonService personService;

    PersonController(PersonService personService) {
        this.personService = personService;
    }

    String personList(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "personsView";
    }
}
