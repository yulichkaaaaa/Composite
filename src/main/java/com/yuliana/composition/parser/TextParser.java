package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;

public class TextParser extends AbstractParser{

    private static final String PARAGRAPH_DELIMITER = "\\r\\n\\s";

    @Override
    public TextComponent parse(String text) {
        TextComposite paragraphs = new TextComposite();
        String[] lexemes = text.split(PARAGRAPH_DELIMITER);
        for(String lexeme : lexemes) {
            paragraphs.add(new TextComposite());
            parseNext(lexeme);
        }
        return paragraphs;
    }

}
