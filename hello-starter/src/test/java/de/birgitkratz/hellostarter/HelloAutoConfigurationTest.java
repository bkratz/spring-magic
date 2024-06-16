package de.birgitkratz.hellostarter;

import de.birgitkratz.helloservice.HelloService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mock.env.MockEnvironment;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class HelloAutoConfigurationTest {
    private ConfigurableApplicationContext context;


    @AfterEach
    void closeContext() {
        if (context != null) {
            context.close();
        }
    }

    @Test
    void helloServiceIsAutoconfigured() {
        load(EmptyConfiguration.class, null, null);
        var helloService = this.context.getBean(HelloService.class);
        var message = helloService.sayHello();

        assertThat(message).isEqualTo("Hello World!");
    }

    @Test
    void helloServiceIsAutoconfigured_german() {
        load(EmptyConfiguration.class, "hello.language", "de");
        var helloService = this.context.getBean(HelloService.class);
        var message = helloService.sayHello();

        assertThat(message).isEqualTo("Hallo Welt!");
    }


    @Test
    void helloServiceAutoConfigurationBacksOff() {
        load(UserConfiguration.class, null, null);
        var helloService = this.context.getBean(HelloService.class);
        var message = helloService.sayHello();

        assertThat(message).isEqualTo("Bonjour le monde!");
    }


    private void load(Class<?> config, String environmentKey, String environmentValue) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(config);
        if (environmentKey != null) {
            ctx.setEnvironment(new MockEnvironment().withProperty(environmentKey, environmentValue));
        }
        ctx.refresh();
        this.context = ctx;
    }

    @Configuration
    @ImportAutoConfiguration(HelloAutoConfiguration.class)
    static class EmptyConfiguration {
    }

    @Configuration
    @Import(EmptyConfiguration.class)
    static class UserConfiguration {

        @Bean
        public HelloService userHelloService() {
            return new HelloService(Locale.FRENCH);
        }
    }
}