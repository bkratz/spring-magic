package de.birgitkratz.helloapp;

import de.birgitkratz.helloservice.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class HelloConfiguration {

    @Bean
    HelloService helloService() {
        return new HelloService(Locale.ITALIAN);
    }
}
