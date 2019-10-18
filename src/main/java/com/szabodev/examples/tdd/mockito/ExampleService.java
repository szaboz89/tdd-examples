package com.szabodev.examples.tdd.mockito;

import java.util.Optional;

public interface ExampleService {

    void save(Example example);

    Optional<Example> findById(Long id);
}
