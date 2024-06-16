package de.birgitkratz.helloapp;

import de.birgitkratz.helloservice.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloAppCommandLineRunner implements CommandLineRunner {

    private final HelloService helloService;

    public HelloAppCommandLineRunner(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void run(String... args) {
        System.out.println(helloService.sayHello());
    }
}
