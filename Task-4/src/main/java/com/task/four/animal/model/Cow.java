package com.task.four.animal.model;

public class Cow extends Animal{
    public Cow(String name) {
        this.name = name;
    }

    @Override
    public String voice(){
        return "Му-му";
    }

}
