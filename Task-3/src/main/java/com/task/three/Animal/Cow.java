package com.task.three.Animal;

import lombok.Data;

@Data
public class Cow {
    private String name;

    public Cow(String name) {
        this.name = name;
    }

    public String voice(){
        return "Му-му";
    }

    @Override
    public String toString() {
        return this.voice();
    }
}
