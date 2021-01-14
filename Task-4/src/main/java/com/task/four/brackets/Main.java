package com.task.four.brackets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Brackets("<,<,>,(,),{,[,],},>").start();
        while (true){
            new Brackets(new Scanner(System.in).nextLine()).start();
        }
    }
}
