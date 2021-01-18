package com.yuliana.composition.parser;

import com.yuliana.composition.entity.CurrentLevel;
import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser{

    private static final String PARAGRAPH = "\\s{4}.+\\r\\n";

    @Override
    public TextComponent parse(String text) {
        TextComposite fullText = new TextComposite();
        Pattern pattern = Pattern.compile(PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            TextComponent paragraph = parseNext(matcher.group());
            fullText.add(paragraph);
        }
        fullText.setCurrentLevel(CurrentLevel.TEXT);
        return fullText;
    }

}
