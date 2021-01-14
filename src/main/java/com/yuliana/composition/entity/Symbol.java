package com.yuliana.composition.entity;

public class Symbol implements Component{

    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String build() {
        return symbol;
    }
}
