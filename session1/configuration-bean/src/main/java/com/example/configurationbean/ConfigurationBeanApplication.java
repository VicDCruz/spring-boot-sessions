package com.example.configurationbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigurationBeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigurationBeanApplication.class, args);
        Transcript transcript = applicationContext.getBean(Transcript.class);
        for (int i = 0; i < 10; i++) {
            transcript.log("This is message #" + i);
        }
    }

}
