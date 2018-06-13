package ru.mirza;

import java.util.LinkedList;
import ru.mirza.Token;
import java.util.List;
import java.util.Queue;

public class Parser {

    private Queue<Token> token;
    private Token currentToken;
    private void match(){
        currentToken = token.poll();
    }
    private Token next(){
        return token.peek();
    }

    private void lang(){
        while (next() != null) {
            expr();
        }
    }
    private void expr(){
        assign_expr();
    }
    private void value_expr(){
        value();
        if (next() != null && next().getLexem().getValue().equals("OP")) {
            op();
            value_expr();
        }
    }
    private void assign_expr(){
        var();
        assing_op();
        value_expr();
    }




    private void value(){
        switch (next().getLexem().getValue())
        {
            case "VAR": var(); break;
            case "DIGIT": digit(); break;
            default:
                throw new IllegalArgumentException("VAR or DIGIT expected but " + currentToken.getLexem().getValue() + " found");
        }
    }
    private void var(){
        match();
        if (!currentToken.getLexem().getValue().equals("VAR")){
            throw new IllegalArgumentException("VAR expected but " + currentToken.getLexem().getValue() + " found");
        }
    }
    private void digit(){
        match();
        if (!currentToken.getLexem().getValue().equals("DIGIT")){
            throw new IllegalArgumentException("DIGIT expected but " + currentToken.getLexem().getValue() + " found");
        }
    }
    private void assing_op(){
        match();
        if (!currentToken.getLexem().getValue().equals("ASSIGNOP")){
            throw new IllegalArgumentException("ASSIGNOP expected but " + currentToken.getLexem().getValue() + " found");
        }
    }
    private void op(){
        match();
        if (!currentToken.getLexem().getValue().equals("OP")){
            throw new IllegalArgumentException("OP expected but " + currentToken.getLexem().getValue() + " found");
        }
    }

    public String parse(List<Token> tokens){
        this.token = new LinkedList<>(tokens);
        lang();
        return "Syntax OK";
    }
}

