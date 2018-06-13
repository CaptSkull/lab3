package ru.mirza;

import java.util.regex.Pattern;

public class Lexem {
    private String value;
    private Pattern pattern;
    public Lexem(String value, Pattern pattern) {
        this.pattern = pattern;
        this.value = value;
    }
    public Pattern getPattern() {
        return pattern;
    }
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}