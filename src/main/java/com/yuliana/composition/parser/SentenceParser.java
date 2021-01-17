package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;
import com.yuliana.composition.entity.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser{

    private static final String SPACE = " ";
    private static final String LEXEME = "[A-Za-zА-Яа-я0-9,.!?()=-]+";

    @Override
    public TextComponent parse(String text) {
        TextComposite sentence = new TextComposite();
        Pattern pattern = Pattern.compile(LEXEME);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            sentence.add(new Symbol(SPACE));
            sentence.add(parseNext(matcher.group()));
        }
        return sentence;
    }
}
