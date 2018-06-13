package ru.mirza;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ru.mirza.Lexer;
import ru.mirza.Token;

import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private Lexer test = new Lexer();
    private Parser p = new Parser();

    @Test
    public void testWithOkSyntax()
    {
        List<Token> tokens = test.process("x  = x ");
        for (Token token : tokens)
            System.out.println(token);

        try {
            System.out.println(p.parse(tokens));
            assertTrue(true);
        } catch (IllegalArgumentException e){
            assertTrue(false);
        }

    }
    @Test
    public void testWithBadSyntax()
    {
        List<Token> tokens = test.process("x=x2x+6");

        try {
            p.parse(tokens);
            assertFalse(true);
        } catch (IllegalArgumentException e){
            assertFalse(false);
        }

    }
}
