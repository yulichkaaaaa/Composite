package com.yuliana.composition.entity;

public interface Component {
    void add(Component component);
    void remove(Component component);
    String build();
}
