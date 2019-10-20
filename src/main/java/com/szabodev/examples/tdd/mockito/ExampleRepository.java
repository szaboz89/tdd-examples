package com.szabodev.examples.tdd.mockito;

import java.util.Optional;

public interface ExampleRepository {

    void save(Example example);

    Optional<Example> findById(Long id);

    void delete(Example example);

    void deleteById(Long id);
}
