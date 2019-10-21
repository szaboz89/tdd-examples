package com.szabodev.examples.tdd.mockito;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExampleRepositoryListImpl implements ExampleRepository {

    private List<Example> examples = new ArrayList<>();
    private long index = 1;

    @Override
    public Example save(Example example) {
        if (example == null) {
            return null;
        }
        if (example.getId() == null) {
            example.setId(index++);
            examples.add(example);
        } else {
            for (Example e : examples) {
                if (e.getId().equals(example.getId())) {
                    e.setName(example.getName());
                    e.setDescription(example.getDescription());
                }
            }
        }
        return example;
    }

    @Override
    public Optional<Example> findById(Long id) {
        for (Example example : examples) {
            if (example.getId().equals(id)) {
                return Optional.of(example);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Example example) {
        if (example == null) {
            return;
        }
        examples.removeIf(e -> example.getId() != null && example.getId().equals(e.getId()));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        examples.removeIf(e -> id.equals(e.getId()));
    }

    @Override
    public List<Example> findAll() {
        return new ArrayList<>(examples);
    }

    @Override
    public List<Example> findAllByNameLike(String searchString) {
        List<Example> result = new ArrayList<>();
        for (Example e : examples) {
            if (e.getName() != null && searchString != null && e.getName().toLowerCase().contains(searchString.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }
}
