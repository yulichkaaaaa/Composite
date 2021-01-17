package com.yuliana.composition.entity;

import java.util.List;

public class Symbol implements TextComponent {

    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public CurrentLevel getCurrentLevel() {
        return CurrentLevel.SYMBOL;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String build() {
        return symbol;
    }
}
