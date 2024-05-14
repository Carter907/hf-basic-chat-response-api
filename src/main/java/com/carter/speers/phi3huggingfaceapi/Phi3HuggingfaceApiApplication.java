package com.carter.speers.phi3huggingfaceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Phi3HuggingfaceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Phi3HuggingfaceApiApplication.class, args);
    }

}
