package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LexemeParserTest {
    private WordParser wordParser;
    private LexemeParser lexemeParser;
    private static final String LEXEME = "asba.6c,";

    @BeforeTest
    private void init(){
        wordParser = new WordParser();
        lexemeParser = new LexemeParser();
        lexemeParser.setNextParser(wordParser);
    }

    @Test
    public void readDataCorrectFileNameTest(){
        TextComponent component = lexemeParser.parse(LEXEME);
        String actual = component.build();
        String expected = "asba.6c,";
        assertEquals(actual, expected);
    }
}
