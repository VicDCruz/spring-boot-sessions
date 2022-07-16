package com.example.configurationbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Transcript transcript() {
        return new Transcript(5, true);
    }
}
