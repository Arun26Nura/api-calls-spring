package com.demo.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    @Profile("!test")
    RestClient accountRestClient(@Value("${app.inventory.account-base-url}") String baseUrl){
        return RestClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    @Profile("!test")
    RestClient studentRestClient(@Value("${app.inventory.student-base-url}") String baseUrl){
        return RestClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    @Profile("test")
    RestClient testRestClient(@Value("${app.inventory.base-url}") String baseUrl){
        return RestClient.builder().baseUrl(baseUrl).build();
    }
}
