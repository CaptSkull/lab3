package ru.mirza;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    private List<Lexem> lexems = new ArrayList<>();

    public Lexer() {
        lexems.add(new Lexem("VAR", Pattern.compile("[a-zA-Z]+")));
        lexems.add(new Lexem("DIGIT", Pattern.compile("0|[1-9][0-9]*")));
        lexems.add(new Lexem("ASSIGNOP", Pattern.compile("=")));
        lexems.add(new Lexem("OP", Pattern.compile("[*/+-]")));
        lexems.add(new Lexem("WS", Pattern.compile("[ \t\f\r\n]+")));
    }

    public List<Token> process(String s) {

        ArrayList<Token> tokens = new ArrayList<Token>();

        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (Lexem tokenType : lexems)
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.getValue(), tokenType.getPattern()));
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

        Matcher matcher = tokenPatterns.matcher(s);
        tokenIteration: while (matcher.find()) {
            for (Lexem tk: lexems) {
                if (matcher.group("WS") != null)
                    continue;
                else if (matcher.group(tk.getValue()) != null) {
                    tokens.add(new Token(tk, matcher.group(tk.getValue())));
                    continue tokenIteration;
                }
            }

        }


        return tokens;
    }
}