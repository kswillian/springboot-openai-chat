package com.kaminski.openai.chat.controller;

import com.kaminski.openai.chat.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("v1/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final OpenAiService openAiService;

    @GetMapping
    public Flux<String> getRecipe(@RequestParam(value = "food", defaultValue = "omelet") String food){
        return openAiService.generateRecipe(food);
    }
}
