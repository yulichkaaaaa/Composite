package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SentenceParserText {

    private SentenceParser sentenceParser;
    private static final String SENTENCE = "It has survived - not only (five) centuries, but also the leap into electronic " +
            "typesetting, remaining essentially unchanged.";

    @BeforeTest
    private void init(){
        WordParser wordParser = new WordParser();
        LexemeParser lexemeParser = new LexemeParser();
        sentenceParser = new SentenceParser();
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
    }

    @Test
    public void parseTest(){
        TextComponent component = sentenceParser.parse(SENTENCE);
        String actual = component.build();
        String expected = "It has survived - not only (five) centuries, but also the leap into electronic" +
                "typesetting, remaining essentially unchanged.";
        assertEquals(actual, expected);
    }
}
