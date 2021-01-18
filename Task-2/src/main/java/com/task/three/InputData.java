package com.task.three;

import java.util.Scanner;

public class InputData {
    public static int checkInt(){
        Scanner scanner = new Scanner(System.in);
        int number;
        while (!scanner.hasNextInt()) {
            System.out.println("You entered an invalid number!");
            System.out.print("Re-enter:");
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }
    public static String inputString(){
        return new Scanner(System.in).nextLine();
    }
}
