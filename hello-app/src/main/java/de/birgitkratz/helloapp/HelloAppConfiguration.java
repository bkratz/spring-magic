package de.birgitkratz.helloapp;

import de.birgitkratz.helloservice.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class HelloAppConfiguration {
    @Bean
    HelloService helloService(@Value("${hello.language:}") String language) {
        var locale = Locale.getDefault();
        if (language != null && !language.isEmpty()) {
            locale = Locale.of(language);
        }
        return new HelloService(locale);
    }
}
