package com.task.two;

import com.task.two.Animal.Cat;
import com.task.two.Animal.Cow;
import com.task.two.Animal.Dog;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        Cat cat = new Cat("Володя");
        Cow cow = new Cow("Буренка");
        Map<String,Object> map = new HashMap<>();
        map.put(dog.getName(),dog);
        map.put(cat.getName(),cat);
        map.put(cow.getName(),cow);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter the name of the animal: ");
            String name = scanner.nextLine();
            System.out.println(map.get(name).toString());
        }

    }
}
