package de.birgitkratz.helloservice;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


class HelloServiceTest {
    @Test
    void sayHello_default() {
        HelloService helloService = new HelloService(Locale.getDefault());
        assertThat(helloService.sayHello()).isEqualTo("Hello World!");
    }
    @Test
    void sayHello_german() {
        HelloService helloService = new HelloService(Locale.GERMAN);
        assertThat(helloService.sayHello()).isEqualTo("Hallo Welt!");
    }
    @Test
    void sayHello_spanish() {
        HelloService helloService = new HelloService(Locale.of("es"));
        assertThat(helloService.sayHello()).isEqualTo("Hola mundo!");
    }
    @Test
    void sayHello_french() {
        HelloService helloService = new HelloService(Locale.FRENCH);
        assertThat(helloService.sayHello()).isEqualTo("Bonjour le monde!");
    }
}