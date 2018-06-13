package ru.mirza;

public class Token {

    private Lexem lexem;
    private String value;

    public Token(Lexem lexem, String value) {
        this.lexem = lexem;
        this.value = value;
    }

    public Lexem getLexem() {
        return lexem;
    }

    public void setLexem(Lexem lexem) {
        this.lexem = lexem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "lexem:" + lexem.getValue() +
                ", value:\'" + value + '\'' +
                '}';
    }
}