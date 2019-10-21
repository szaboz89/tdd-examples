package com.szabodev.examples.tdd.mockito;

import com.szabodev.examples.tdd.fakespring.BindingResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
