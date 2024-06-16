package de.birgitkratz.helloservice;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloService {
    private final Locale language;

    public HelloService(Locale language) {
        this.language = language;
    }

    public String sayHello() {
        ResourceBundle message = ResourceBundle.getBundle("de.birgitkratz.helloservice.message", language);
        return message.getString("message");
    }
}
