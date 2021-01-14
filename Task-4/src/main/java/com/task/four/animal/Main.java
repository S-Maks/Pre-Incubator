package com.task.four.animal;

import com.task.four.animal.model.Animal;
import com.task.four.animal.model.Cat;
import com.task.four.animal.model.Cow;
import com.task.four.animal.model.Dog;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        Cat cat = new Cat("Володя");
        Cow cow = new Cow("Буренка");
        Map<String, Animal> map = new HashMap<>();
        map.put(dog.getName(),dog);
        map.put(cat.getName(),cat);
        map.put(cow.getName(),cow);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter the name of the animal: ");
            String name = scanner.nextLine();
            try {
                Printer.print(map.get(name));
            }catch (NullPointerException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
