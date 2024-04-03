package com.kaminski.openai.chat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final OpenAiChatClient chatClient;

    public Flux<String> generateRecipe(String food) {

        var prompt = new Prompt(String.format(
                "Por favor, me forneca uma receita simples e breve do prato %s",
                food
        ));

        return chatClient.stream(prompt.getContents());

    }
}