package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {
    private ParagraphParser paragraphParser;
    private static final String PARAGRAPH = "    It has survived - not only (five) centuries, but also the leap into electronic " +
            "typesetting, remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) " +
            "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and " +
            "more recently with desktop publishing software like Aldus PageMaker Faclon9 including " +
            "versions of Lorem Ipsum!\r\n";

    @BeforeTest
    private void init(){
        WordParser wordParser = new WordParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        paragraphParser = new ParagraphParser();
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
    }

    @Test
    public void parseTest(){
        TextComponent component = paragraphParser.parse(PARAGRAPH);
        String actual = component.build();
        String expected = "It has survived - not only (five) centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) " +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and " +
                "more recently with desktop publishing software like Aldus PageMaker Faclon9 including " +
                "versions of Lorem Ipsum!";
        assertEquals(actual, expected);
    }
}
