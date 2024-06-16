package de.birgitkratz.hellostarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties("hello")
public class HelloProperties {

    /**
     * Language short name of the language you want to get greeted in.
     */
    private String language;

    public Locale getLocale() {
        var locale = Locale.getDefault();
        if (language != null && !language.isEmpty()) {
            locale = Locale.of(language);
        }
        return locale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
