package com.task.eight;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start task 8");
        for (int i = 0; i < 1; i++) {
            new ThreadClass(i + " " + "thread").start();
        }
    }
}
