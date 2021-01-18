package com.task.three;

import java.util.Scanner;

public class InputData {
    public static int checkInt(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("You entered an invalid number!");
            System.out.print("Re-enter:");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static String inputString(){
        return new Scanner(System.in).nextLine();
    }
}
