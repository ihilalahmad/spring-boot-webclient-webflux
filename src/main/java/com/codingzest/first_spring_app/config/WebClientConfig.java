package com.codingzest.first_spring_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                        .baseUrl("https://dummyjson.com/posts/")
                        .build();
    }
}
