package com.task.four.animal.model;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String voice() {
        return "Гав-гав";
    }
}
