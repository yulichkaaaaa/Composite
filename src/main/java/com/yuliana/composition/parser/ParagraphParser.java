package com.yuliana.composition.parser;

import com.yuliana.composition.entity.Component;
import com.yuliana.composition.entity.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser{
    private static final String SENTENCE = "^[A-ZА-Я].+[.?!]$";
    @Override
    public Component parse(String text) {
        Composite paragraph = new Composite();
        Pattern pattern = Pattern.compile(SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            paragraph.add(new Composite());
            parseNext(matcher.group());
        }
        return paragraph;
    }
}
