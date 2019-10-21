package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplTest {

    private Example example;

    @Mock
    ExampleRepository exampleRepository;

    @InjectMocks
    ExampleServiceImpl exampleService;

    @BeforeEach
    void setUp() {
        example = new Example("Test");
    }

    @Test
    void save() {
        exampleService.save(example);
        exampleService.save(example);

        verify(exampleRepository, times(2)).save(example);
        verify(exampleRepository, atLeastOnce()).save(example);
        verify(exampleRepository, atMost(3)).save(example);

        verify(exampleRepository, never()).save(new Example("Wrong"));
    }

    @Test
    void findById() {
        when(exampleRepository.findById(1L)).thenReturn(Optional.of(example));

        Example foundExample = exampleService.findById(1L).orElse(new Example("Wrong"));

        assertNotEquals(null, foundExample);
        verify(exampleRepository, times(1)).findById(1L);
        assertEquals("Test", foundExample.getName());
    }

    @Test
    void argumentMatcherExample() {
        exampleService.save(example);
        exampleService.findById(1L);

        verify(exampleRepository, times(1)).save(any(Example.class));
        verify(exampleRepository, times(1)).findById(anyLong());
    }
}
