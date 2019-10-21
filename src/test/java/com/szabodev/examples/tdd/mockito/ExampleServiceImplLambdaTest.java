package com.szabodev.examples.tdd.mockito;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ExampleServiceImplLambdaTest {

    @Mock
    ExampleRepository exampleRepository;

    @InjectMocks
    ExampleServiceImpl exampleService;

    @Test
    void testSaveLambda() {
        // given
        final String MATCH_ME = "MATCH_ME";
        Example example = new Example();
        example.setDescription(MATCH_ME);

        Example savedExample = new Example();
        savedExample.setId(1L);

        // need mock to only return on match MATCH_ME string
        given(exampleRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME)))).willReturn(savedExample);

        // when
        Example returnedExample = exampleService.save(example);

        // then
        assertThat(returnedExample.getId()).isEqualTo(1L);
    }

    @Disabled
    @Test
    void testSaveLambdaNoMatch() {
        // given
        final String MATCH_ME = "MATCH_ME";
        Example example = new Example();
        example.setDescription("Not a match");

        Example savedExample = new Example();
        savedExample.setId(1L);

        // need mock to only return on match MATCH_ME string
        given(exampleRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME)))).willReturn(savedExample);

        // when
        Example returnedExample = exampleService.save(example);

        // then
        assertNull(returnedExample);
    }
}
