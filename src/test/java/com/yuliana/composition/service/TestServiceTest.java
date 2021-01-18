package com.yuliana.composition.service;

import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;
import com.yuliana.composition.parser.*;
import com.yuliana.composition.service.impl.TextServiceImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestServiceTest {
    private TextComposite composite;
    private static final String TEXT = "    It is a long a!=b established fact that a reader will be distracted by the readable " +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
            "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
            "content here's, making it look like readable English?\r\n" +
            "    It is a established fact that a reader will be of a page when looking at its layout...\r\n" +
            "    Bye бандерлоги.Bye бандерлоги.\r\n";
    private TextService textService;

    @BeforeTest
    private void init(){
        WordParser wordParser = new WordParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        TextParser textParser = new TextParser();
        textParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        composite = (TextComposite) textParser.parse(TEXT);
        textService = new TextServiceImpl();
    }

    @Test
    public void sortParagraphBySentenceCountTest(){
        String actual = textService.sortParagraphBySentenceCount(composite).build();
        String expected = "    It is a long a!=b established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
                "content here's, making it look like readable English?\r\n" +
                "    Bye бандерлоги.Bye бандерлоги.\r\n" +
                "    It is a established fact that a reader will be of a page when looking at its layout...\r\n";
        assertEquals(actual, expected);
    }
}
