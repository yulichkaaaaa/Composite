package com.yuliana.composition.parser;

import com.yuliana.composition.entity.CurrentLevel;
import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser{
    private static final String SENTENCE = "[A-ZА-Я0-9\"].+[.?!](\\s|)";
    @Override
    public TextComponent parse(String text) {
        TextComposite paragraph = new TextComposite();
        Pattern pattern = Pattern.compile(SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            TextComponent sentence = parseNext(matcher.group());
            paragraph.add(sentence);
        }
        paragraph.setCurrentLevel(CurrentLevel.PARAGRAPH);
        return paragraph;
    }
}
