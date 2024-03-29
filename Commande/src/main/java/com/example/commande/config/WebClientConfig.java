package com.example.commande.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient getClient(){
       return WebClient.builder()
               .baseUrl("http://localhost:8090")
               .build();
    }
}
