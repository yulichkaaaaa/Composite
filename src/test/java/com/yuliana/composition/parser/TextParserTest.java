package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    private TextParser textParser;
    private static final String TEXT = "    It is a long a!=b established fact that a reader will be distracted by the readable " +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
            "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
            "content here's, making it look like readable English?\r\n" +
            "    It is a established fact that a reader will be of a page when looking at its layout...\r\n" +
            "    Bye бандерлоги.\r\n";

    @BeforeTest
    private void init(){
        WordParser wordParser = new WordParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        textParser = new TextParser();
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);

    }

    @Test
    public void parseTest(){
        TextComponent component = textParser.parse(TEXT);
        String actual = component.build();
        String expected = "    It is a long a!=b established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
                "content here's, making it look like readable English?\r\n" +
                "    It is a established fact that a reader will be of a page when looking at its layout...\r\n" +
                "    Bye бандерлоги.\r\n";
        assertEquals(actual, expected);
    }
}
