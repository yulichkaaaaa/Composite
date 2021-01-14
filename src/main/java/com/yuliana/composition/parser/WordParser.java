package com.yuliana.composition.parser;

import com.yuliana.composition.entity.Component;
import com.yuliana.composition.entity.Composite;
import com.yuliana.composition.entity.Symbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractParser{

    private static final String SYMBOL = "[A-Za-z0-9А-Яа-я().?:\"!=]";
    @Override
    public Component parse(String text) {
        Composite word = new Composite();
        Pattern pattern = Pattern.compile(SYMBOL);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String symbol = matcher.group();
            word.add(new Symbol(symbol));
        }
        return word;
    }
}
