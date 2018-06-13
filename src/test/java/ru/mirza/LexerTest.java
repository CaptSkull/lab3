package ru.mirza;


import org.junit.Test;
import ru.mirza.Lexer;
import ru.mirza.Token;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LexerTest {

    private Lexer l = new Lexer();

    @Test
    public void VAR() {
        Token token = l.process("abc").get(0);
        assertTrue(token.getLexem().getValue().equals("VAR") &&
                token.getValue().equals("abc"));

        token = l.process("nik").get(0);
        assertTrue(token.getLexem().getValue().equals("VAR") &&
                token.getValue().equals("nik"));
    }

    @Test
    public void DIGIT() {
        List<Token> tokens = l.process("123");
        assertTrue(tokens.get(0).getLexem().getValue().equals("DIGIT"));
    }

    @Test
    public void ASSIGNOP() {
        List<Token> tokens = l.process("=");
        assertTrue(tokens.get(0).getLexem().getValue().equals("ASSIGNOP"));
    }


    @Test
    public void OP() {
        List<Token> tokens = l.process("+ -");

        Token token = tokens.get(0);                                                // Получаем n-ый токен
        assertTrue(token.getLexem().getValue().equals("OP") &&            // Проверяем токен на тип
                token.getValue().equals("+"));                                      // сравниваем полученное значение с ожидаемым

        token = tokens.get(1);
        assertTrue(token.getLexem().getValue().equals("OP") &&
                token.getValue().equals("-"));

        tokens = l.process("* /");
        token = tokens.get(0);
        assertTrue(token.getLexem().getValue().equals("OP") &&
                token.getValue().equals("*"));
        token = tokens.get(1);
        assertTrue(token.getLexem().getValue().equals("OP") &&
                token.getValue().equals("/"));
    }

    @Test
    public void testLexer() {
        List<Token> tokens = l.process("baka=2+3+4*4");
        Token pr;

        pr = tokens.get(8);
        assertTrue(pr.getLexem().getValue().equals("DIGIT") && pr.getValue().equals("4"));

        pr = tokens.get(0);
        assertTrue(pr.getLexem().getValue().equals("VAR") && pr.getValue().equals("baka"));

        pr = tokens.get(1);
        assertTrue(pr.getLexem().getValue().equals("ASSIGNOP") && pr.getValue().equals("="));

        pr = tokens.get(2);
        assertTrue(pr.getLexem().getValue().equals("DIGIT") && pr.getValue().equals("2"));

        pr = tokens.get(3);
        assertTrue(pr.getLexem().getValue().equals("OP") && pr.getValue().equals("+"));

        pr = tokens.get(4);
        assertTrue(pr.getLexem().getValue().equals("DIGIT") && pr.getValue().equals("3"));

        pr = tokens.get(7);
        assertTrue(pr.getLexem().getValue().equals("OP") && pr.getValue().equals("*"));

        pr = tokens.get(5);
        assertTrue(pr.getLexem().getValue().equals("OP") && pr.getValue().equals("+"));

        pr = tokens.get(6);
        assertTrue(pr.getLexem().getValue().equals("DIGIT") && pr.getValue().equals("4"));

    }

}