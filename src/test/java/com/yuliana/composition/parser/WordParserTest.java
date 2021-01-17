package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WordParserTest {
    private WordParser wordParser;
    private static final String WORD = "asba.6c";

    @BeforeTest
    private void init(){
        wordParser = new WordParser();
    }

    @Test
    public void parseTest(){
        TextComponent component = wordParser.parse(WORD);
        String actual = component.build();
        String expected = "asba.6c";
        assertEquals(actual, expected);
    }
}
