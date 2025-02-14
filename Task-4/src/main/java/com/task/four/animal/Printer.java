package com.task.four.animal;

import com.task.four.animal.model.Animal;
import com.task.four.animal.model.Cat;
import com.task.four.animal.model.Cow;
import com.task.four.animal.model.Dog;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Printer {
    private Map<String, Animal> map;

    Printer() {
        map = new HashMap<>();
    }

    public void start() {
        while (true) {
            System.out.println("1 - add animal");
            System.out.println("2 - find voice");
            System.out.println("0 - exit");
            switch (InputData.checkInt()) {
                case 1 -> this.addAnimal();
                case 2 -> this.findVoice();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Incorrect value");
            }
        }
    }

    private void addAnimal() {
        while (true) {
            String name;
            System.out.println("1 - add cat");
            System.out.println("2 - add dog");
            System.out.println("3 - add cow");
            System.out.println("0 - exit");
            switch (InputData.checkInt()) {
                case 1 -> {
                    System.out.print("Enter the name for cat:");
                    name = InputData.inputString();
                    map.put(name, new Cat(name));
                }
                case 2 -> {
                    System.out.print("Enter the name for dog:");
                    name = InputData.inputString();
                    map.put(name, new Dog(name));
                }
                case 3 -> {
                    System.out.print("Enter the name for cow:");
                    name = InputData.inputString();
                    map.put(name, new Cow(name));
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Incorrect value");
            }
        }
    }

    private void findVoice() {
        System.out.print("Enter the name of the animal: ");
        try {
            Printer.print(map.get(InputData.inputString()));
        } catch (NullPointerException ex) {
            System.out.println("Not found!");
            System.out.println(ex.getMessage());
        }
    }

    public static <T extends Animal> void print(T obj) {
        System.out.println(obj.voice());
    }
}
