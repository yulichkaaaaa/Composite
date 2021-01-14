package com.yuliana.composition.parser;

import com.yuliana.composition.entity.Component;

public abstract class AbstractParser {
    protected AbstractParser nextParser;

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    public Component parseNext(String text){
        Component component = nextParser.parse(text);
        if(nextParser != null){
            nextParser.parseNext(text);
        }
        return component;
    }

    public abstract Component parse(String text);
}
