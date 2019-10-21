package com.szabodev.examples.tdd.mockito;

import com.szabodev.examples.tdd.fakespring.BindingResult;
import com.szabodev.examples.tdd.fakespring.Model;

import java.util.List;

public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public String processFindForm(Example example, BindingResult result, Model model) {
        if (example.getName() == null) {
            example.setName("");
        }
        List<Example> results = exampleService.findAllByNameLike("%" + example.getName() + "%");
        if (results.isEmpty()) {
            result.rejectValue("name", "notFound", "not found");
            return "example/findExamples";
        } else if (results.size() == 1) {
            example = results.get(0);
            return "redirect:/examples/" + example.getId();
        } else {
            model.addAttribute("examples", results);
            return "example/findExamples";
        }
    }

    @SuppressWarnings("WeakerAccess")
    public String processCreationForm(Example example, BindingResult result) {
        if (result.hasErrors()) {
            return "example/createOrUpdateExampleForm";
        } else {
            Example savedExample = exampleService.save(example);
            return "redirect:/examples/" + savedExample.getId();
        }
    }
}
