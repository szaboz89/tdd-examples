package com.szabodev.examples.tdd.mockito;

import com.szabodev.examples.tdd.fakespring.BindingResult;
import com.szabodev.examples.tdd.fakespring.Model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ExampleControllerTest {

    private static final String EXAMPLE_CREATE_OR_UPDATE_OWNER_FORM = "example/createOrUpdateExampleForm";
    private static final String REDIRECT_EXAMPLES_5 = "redirect:/examples/5";

    @Mock
    ExampleService exampleService;

    @InjectMocks
    ExampleController exampleController;

    @Mock
    BindingResult bindingResult;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    void givenWithAnswer() {
        given(exampleService.findAllByNameLike(stringArgumentCaptor.capture()))
                .willAnswer(invocation -> {
                    List<Example> examples = new ArrayList<>();
                    String name = invocation.getArgument(0);
                    switch (name) {
                        case "%Test1%":
                            examples.add(new Example(1L, "Test1", "Test"));
                            return examples;
                        case "%DontFindMe%":
                            return examples;
                        case "%FindMe%":
                            examples.add(new Example(1L, "FindMe1", "Test"));
                            examples.add(new Example(2L, "FindMe2", "Test"));
                            return examples;
                    }
                    throw new RuntimeException("Invalid Argument");
                });
    }

    @Test
    void testFindFormWithAnswer1() {
        // given
        Example example = new Example(1L, "FindMe", "Test");
        givenWithAnswer();

        // when
        String viewName = exampleController.processFindForm(example, bindingResult, Mockito.mock(Model.class));

        // then
        assertThat("%FindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("example/findExamples").isEqualToIgnoringCase(viewName);
    }

    @Test
    void testFindFormWithAnswer2() {
        // given
        Example example = new Example(1L, "Test1", "Test");
        givenWithAnswer();

        // when
        String viewName = exampleController.processFindForm(example, bindingResult, null);

        // then
        assertThat("%Test1%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("redirect:/examples/1").isEqualToIgnoringCase(viewName);
    }


    @Test
    void testFindFormWithAnswer3() {
        // given
        Example example = new Example(1L, "DontFindMe", "DontFindMe");
        givenWithAnswer();

        // when
        String viewName = exampleController.processFindForm(example, bindingResult, null);

        // then
        assertThat("%DontFindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("example/findExamples").isEqualToIgnoringCase(viewName);
    }

    @Test
    void processFindFormWildcardString() {
        // given
        Example example = new Example(1L, "Test", "Test");
        List<Example> exampleList = new ArrayList<>();
        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        given(exampleService.findAllByNameLike(captor.capture())).willReturn(exampleList);

        // when
        String viewName = exampleController.processFindForm(example, bindingResult, null);

        // then
        assertThat("%Test%").isEqualToIgnoringCase(captor.getValue());
    }

    @Test
    void processFindFormWildcardStringAnnotation() {
        // given
        Example example = new Example(1L, "Test", "Test");
        List<Example> exampleList = new ArrayList<>();
        given(exampleService.findAllByNameLike(stringArgumentCaptor.capture())).willReturn(exampleList);

        // when
        String viewName = exampleController.processFindForm(example, bindingResult, null);

        // then
        assertThat("%Test%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
    }

    @Test
    void processCreationFormHasErrors() {
        // given
        Example example = new Example(1L, "Test", "Test");
        given(bindingResult.hasErrors()).willReturn(true);

        // when
        String viewName = exampleController.processCreationForm(example, bindingResult);

        // then
        assertThat(viewName).isEqualToIgnoringCase(EXAMPLE_CREATE_OR_UPDATE_OWNER_FORM);
    }

    @Test
    void processCreationFormNoErrors() {
        // given
        Example example = new Example(5L, "Test", "Test");
        given(bindingResult.hasErrors()).willReturn(false);
        given(exampleService.save(any())).willReturn(example);

        // when
        String viewName = exampleController.processCreationForm(example, bindingResult);

        // then
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_EXAMPLES_5);
    }
}
