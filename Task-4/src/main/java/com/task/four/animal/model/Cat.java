package com.task.four.animal.model;

public class Cat extends Animal{
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String voice(){
        return "Мур-мур";
    }

}
