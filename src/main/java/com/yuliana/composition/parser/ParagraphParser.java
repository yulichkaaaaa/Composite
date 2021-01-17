package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser{
    private static final String SENTENCE = "^[A-ZА-Я].+[.?!]$";
    @Override
    public TextComponent parse(String text) {
        TextComposite paragraph = new TextComposite();
        Pattern pattern = Pattern.compile(SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            paragraph.add(new TextComposite());
            parseNext(matcher.group());
        }
        return paragraph;
    }
}
