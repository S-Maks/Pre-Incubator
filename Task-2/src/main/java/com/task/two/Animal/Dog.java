package com.task.two.Animal;

import lombok.Data;

@Data
public class Dog {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String voice() {
        return "Гав-гав";
    }

    @Override
    public String toString() {
        return this.voice();
    }
}
