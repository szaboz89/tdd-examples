package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplExceptionTest {

    @SuppressWarnings("unused")
    @Mock
    ExampleRepository exampleRepository;

    @InjectMocks
    ExampleServiceImpl exampleService;

    @Test
    void testDeleteDoThrow() {
        doThrow(new RuntimeException("Error")).when(exampleRepository).delete(any());

        assertThrows(RuntimeException.class, () -> exampleRepository.delete(new Example("Test")));

        verify(exampleRepository).delete(any());
    }

    @Test
    void testFindByIdWillThrow() {
        given(exampleRepository.findById(1L)).willThrow(new RuntimeException("Error"));

        assertThrows(RuntimeException.class, () -> exampleService.findById(1L));

        then(exampleRepository).should().findById(1L);
    }

    @Test
    void testDeleteBDD() {
        willThrow(new RuntimeException("boom")).given(exampleRepository).delete(any());

        assertThrows(RuntimeException.class, () -> exampleRepository.delete(new Example("Test")));

        then(exampleRepository).should().delete(any());
    }
}
