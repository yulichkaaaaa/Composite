package com.yuliana.composition.parser;

import com.yuliana.composition.entity.Component;
import com.yuliana.composition.entity.Composite;

public class SentenceParser extends AbstractParser{

    private static final String LEXEME_DELIMITER = " ";

    @Override
    public Component parse(String text) {
        Composite sentence = new Composite();
        String[] lexemes = text.split(LEXEME_DELIMITER);
        for(String lexeme : lexemes) {
            sentence.add(new Composite());
            parseNext(lexeme);
        }
        return sentence;
    }
}
