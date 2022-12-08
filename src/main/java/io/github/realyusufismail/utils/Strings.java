package io.github.realyusufismail.utils;

public enum Strings {
    WELCOME("Welcome to the weather skill, you can ask me for the weather in a city located in the United Kingdom"),
    HELP("You can ask me for the weather in a city located in the United Kingdom"),
    ERROR("Sorry, I couldn't understand what you said. Please try again."),
    STOP("Goodbye!");

    private final String value;

    Strings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
