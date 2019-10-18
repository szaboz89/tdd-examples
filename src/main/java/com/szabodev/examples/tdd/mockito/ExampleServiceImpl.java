package com.szabodev.examples.tdd.mockito;

import java.util.Optional;

public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public void save(Example example) {
        exampleRepository.save(example);
    }

    @Override
    public Optional<Example> findById(Long id) {
        return exampleRepository.findById(id);
    }
}
