package com.szabodev.examples.tdd.mockito;

import com.szabodev.examples.tdd.fakespring.BindingResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
