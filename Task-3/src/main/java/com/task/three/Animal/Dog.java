package com.task.three.Animal;

import lombok.Data;

@Data
public class Dog {
    private String name;

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
