package com.yuliana.composition.entity;

import java.util.List;

public interface TextComponent {

    void add(TextComponent component);
    void remove(TextComponent component);
    String build();
    CurrentLevel getCurrentLevel();
    List<TextComponent> getComponents();

}
