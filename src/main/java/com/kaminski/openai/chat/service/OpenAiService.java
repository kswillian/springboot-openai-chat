package com.kaminski.openai.chat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final OpenAiChatClient chatClient;

    public Flux<String> generateRecipe(String food) {

        var promptTemplate = new PromptTemplate("""
                Por favor, me forneca uma receita simples e breve do prato {food}
                """);

        promptTemplate.add("food", food);

        return chatClient.stream(promptTemplate.getTemplate());

    }
}
