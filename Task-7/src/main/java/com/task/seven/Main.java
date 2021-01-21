package com.task.seven;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start task 7");
        for (int i = 0; i < 1000; i++) {
            new ThreadClass(i + " " + "thread").start();
        }
    }
}
