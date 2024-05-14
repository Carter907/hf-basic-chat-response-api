package com.carter.speers.phi3huggingfaceapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "hf.config")
public record HuggingFaceConfig(String apiKey, String basePath) {
}
