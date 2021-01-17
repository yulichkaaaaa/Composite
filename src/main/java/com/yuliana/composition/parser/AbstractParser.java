package com.yuliana.composition.parser;

import com.yuliana.composition.entity.TextComponent;

public abstract class AbstractParser {
    protected AbstractParser nextParser;

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    public TextComponent parseNext(String text){
        if(nextParser != null){
            return nextParser.parse(text);
        }
        return null;
    }

    public abstract TextComponent parse(String text);
}
