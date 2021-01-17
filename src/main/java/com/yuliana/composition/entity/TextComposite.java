package com.yuliana.composition.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

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
        String result = "";
        for(TextComponent component : components){
            result += component.build();
        }
        return result;
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
