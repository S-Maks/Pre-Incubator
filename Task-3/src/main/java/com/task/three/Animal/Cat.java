package com.task.three.Animal;

import lombok.Data;

@Data
public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String voice(){
        return "Мур-мур";
    }

    @Override
    public String toString() {
        return this.voice();
    }
}
