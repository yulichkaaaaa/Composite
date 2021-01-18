package com.yuliana.composition.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private static final String SPACE = " ";
    private static final String TAB = "    ";
    private static final String PARAGRAPH_DELIMITER = "\r\n";

    private List<TextComponent> components = new ArrayList<>();
    private CurrentLevel currentLevel;

    @Override
    public void add(TextComponent component) {
        if (component != null){
            components.add(component);
        }
    }

    @Override
    public void remove(TextComponent component) {
        if(components.contains(component)){
            component.remove(component);
        }
    }

    @Override
    public String build() {
        StringBuilder builder = new StringBuilder();
        switch (currentLevel){
            case SENTENCE:
                for(TextComponent component : components){
                    builder.append(SPACE).append(component.build());
                }
                builder.deleteCharAt(0);
                break;
            case TEXT:
                for(TextComponent component : components){
                    builder.append(TAB).append(component.build()).append(PARAGRAPH_DELIMITER);
                }
                break;
            default:
                for(TextComponent component : components){
                    builder.append(component.build());
                }
        }
        return builder.toString();
    }

    public CurrentLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(CurrentLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public List<TextComponent> getComponents() {
        return components;
    }
}
