package com.task.four.animal;

import com.task.four.animal.model.Animal;

public class Printer {
    public static <T extends Animal> void print(T obj){
        System.out.println(obj.voice());
    }
}
