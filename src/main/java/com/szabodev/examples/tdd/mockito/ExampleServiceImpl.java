package com.szabodev.examples.tdd.mockito;

import java.util.Optional;

public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public Example save(Example example) {
        return exampleRepository.save(example);
    }

    @Override
    public Optional<Example> findById(Long id) {
        return exampleRepository.findById(id);
    }

    @Override
    public void delete(Example example) {
        exampleRepository.delete(example);
    }

    @Override
    public void deleteById(Long id) {
        exampleRepository.deleteById(id);
    }
}
