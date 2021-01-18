package com.yuliana.composition.parser;

import com.yuliana.composition.entity.CurrentLevel;
import com.yuliana.composition.entity.TextComponent;
import com.yuliana.composition.entity.TextComposite;
import com.yuliana.composition.entity.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser{
    public static final String WORD = "^[A-Za-zА-Яа-я0-9-()\".=!']*[A-Za-zА-Яа-я0-9\"()]";
    public static final String PUNCTUATION_MARK = "[,.!?-]{1,3}$";

    @Override
    public TextComponent parse(String text) {
        TextComposite lexeme = new TextComposite();

        Pattern pattern = Pattern.compile(WORD);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            lexeme.add(parseNext(matcher.group()));
        }
        pattern = Pattern.compile(PUNCTUATION_MARK);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            lexeme.add(new Symbol(matcher.group()));
        }
        lexeme.setCurrentLevel(CurrentLevel.LEXEME);
        return lexeme;
    }
}
