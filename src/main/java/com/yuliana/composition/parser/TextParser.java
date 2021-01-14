package com.yuliana.composition.parser;

import com.yuliana.composition.entity.Component;
import com.yuliana.composition.entity.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser{

    private static final String PARAGRAPH_DELIMITER = "\\r\\n\\s";

    @Override
    public Component parse(String text) {
        Composite paragraphs = new Composite();
        String[] lexemes = text.split(PARAGRAPH_DELIMITER);
        for(String lexeme : lexemes) {
            paragraphs.add(new Composite());
            parseNext(lexeme);
        }
        return paragraphs;
    }

}
