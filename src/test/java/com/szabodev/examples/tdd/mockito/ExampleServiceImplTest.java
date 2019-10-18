package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplTest {

    private Example example;

    @SuppressWarnings("unused")
    @Mock
    ExampleRepository exampleRepository;

    @InjectMocks
    ExampleServiceImpl exampleService;

    @BeforeEach
    void setUp() {
        example = new Example();
    }

    @Test
    void save() {
        exampleService.save(example);
    }
}
