package com.szabodev.examples.tdd.mockito;

class Example {

    private Long Id;

    private String name;

    private String description;

    Example() {
    }

    Example(String name) {
        this.name = name;
    }

    public Example(Long id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }

    Long getId() {
        return Id;
    }

    void setId(Long id) {
        Id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }
}
