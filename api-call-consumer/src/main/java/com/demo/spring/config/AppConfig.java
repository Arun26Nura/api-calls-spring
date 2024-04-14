package com.demo.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    @Profile("!test")
    WebClient accountWebClient(@Value("${app.inventory.account-base-url}") String baseUrl){
        return WebClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    @Profile("!test")
    WebClient studentWebClient(@Value("${app.inventory.student-base-url}") String baseUrl){
        return WebClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    @Profile("test")
    WebClient testWebClient(@Value("${app.inventory.base-url}") String baseUrl){
        return WebClient.builder().baseUrl(baseUrl).build();
    }
}
