package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplSpyTest {

    @Spy
    ExampleRepositoryListImpl exampleRepository;

    @InjectMocks
    ExampleServiceImpl exampleService;

    @Test
    void findAll() {
        // given
        Example example = new Example();
        example.setName("Test1");
        example.setDescription("Test");
        exampleRepository.save(example);

        Example example2 = new Example();
        example2.setName("Test2");
        example2.setDescription("Test");
        exampleRepository.save(example2);

        given(exampleRepository.findAll()).willCallRealMethod();

        // when
        List<Example> examples = exampleService.findAll();

        // then
        assertThat(examples).isNotEmpty();
        verify(exampleRepository, times(1)).findAll();
    }

    @Test
    void findAllWithStubbing() {
        // given
        Example example = new Example();
        example.setName("Test1");
        example.setDescription("Test");
        exampleRepository.save(example);

        Example example2 = new Example();
        example2.setName("Test2");
        example2.setDescription("Test");
        exampleRepository.save(example2);

        given(exampleRepository.findAll()).willReturn(Arrays.asList(example, example2));

        // when
        List<Example> examples = exampleService.findAll();

        // then
        assertThat(examples).isNotEmpty();
        verify(exampleRepository, times(1)).findAll();
    }
}
