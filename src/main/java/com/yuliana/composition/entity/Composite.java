package com.yuliana.composition.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    private List<Component> components = new ArrayList<>();
    //private CurrentLevel currentLevel;

    @Override
    public void add(Component component) {
        if (component != null){
            components.add(component);
        }
    }

    @Override
    public void remove(Component component) {
        if(components.contains(component)){
            component.remove(component);
        }
    }

    @Override
    public String build() {
        String result = "";
        for(Component component : components){
            result += component.build();
        }
        return result;
    }
}
