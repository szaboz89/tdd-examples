package com.szabodev.examples.tdd.mockito;

import java.util.List;
import java.util.Optional;

public interface ExampleRepository {

    Example save(Example example);

    Optional<Example> findById(Long id);

    void delete(Example example);

    void deleteById(Long id);

    List<Example> findAll();

    List<Example> findAllByNameLike(String searchString);
}
