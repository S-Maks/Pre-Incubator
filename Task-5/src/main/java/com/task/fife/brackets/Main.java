package com.task.fife.brackets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start task 5");
        new Brackets("<,<,>,(,),{,[,],},>").start();
        while (true){
            new Brackets(new Scanner(System.in).nextLine()).start();
        }
    }
}
