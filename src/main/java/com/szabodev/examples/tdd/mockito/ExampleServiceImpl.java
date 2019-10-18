package com.szabodev.examples.tdd.mockito;

public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public void save(Example example) {
        exampleRepository.save(example);
    }
}
