package com.carter.speers.phi3huggingfaceapi;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.huggingface.HuggingfaceChatClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping("/gen")
public class GenerationController {
    private HuggingFaceConfig hfConfig;
    HttpClient client = HttpClient.newHttpClient();

    public GenerationController(HuggingFaceConfig hfConfig) {
        this.hfConfig = hfConfig;
    }

    @GetMapping("/simple")
    public String simpleGen(
            @RequestParam(value = "prompt", defaultValue = "What is the history of Medieval music?")
            String message
    ) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(hfConfig.basePath()))
                .header("Authorization", "Bearer " + hfConfig.apiKey())
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.format("{ \"inputs\": \"%s\" }", message)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        return response.body();
    }
}
