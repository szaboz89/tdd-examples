package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplBddTest {

    @SuppressWarnings("unused")
    @Mock
    ExampleRepository exampleRepository;

    @InjectMocks
    ExampleServiceImpl exampleService;

    @Test
    void testFindById() {
        // given
        Example example = new Example("Test");
        given(exampleRepository.findById(1L)).willReturn(Optional.of(example));

        // when
        Example foundExample = exampleService.findById(1L).orElse(new Example("Wrong"));

        // then
        assertThat(foundExample).isNotNull();
        then(exampleRepository).should(timeout(100)).findById(anyLong());
        then(exampleRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void testDelete() {
        // given
        Example example = new Example("Test");

        // when
        exampleService.delete(example);

        // then
        then(exampleRepository).should().delete(any(Example.class));
    }

    @Test
    void testDeleteById() {
        // given - none

        // when
        exampleService.deleteById(1L);
        exampleService.deleteById(1L);

        // then
        then(exampleRepository).should(times(2)).deleteById(1L);
        then(exampleRepository).should(atLeastOnce()).deleteById(1L);
        then(exampleRepository).should(atMost(5)).deleteById(1L);
        then(exampleRepository).should(never()).deleteById(5L);
    }

    @Test
    void testDelete2() {
        // when
        exampleService.delete(new Example("Test"));

        // then
        then(exampleRepository).should().delete(any());
    }
}
