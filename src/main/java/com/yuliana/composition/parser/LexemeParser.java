package com.yuliana.composition.parser;

import com.yuliana.composition.entity.Component;
import com.yuliana.composition.entity.Composite;
import com.yuliana.composition.entity.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser{
    public static final String WORD = "[A-Za-z0-9-().=!']+[A-Za-z0-9]$";
    public static final String PUNCTUATION_MARK = ".{0,2}[.!?-]$";

    @Override
    public Component parse(String text) {
        Composite lexeme = new Composite();
        Pattern pattern = Pattern.compile(WORD);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            lexeme.add(new Composite());
            parseNext(matcher.group());
        }
        pattern = Pattern.compile(PUNCTUATION_MARK);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            lexeme.add(new Symbol(matcher.group()));
        }
        return lexeme;
    }
}
