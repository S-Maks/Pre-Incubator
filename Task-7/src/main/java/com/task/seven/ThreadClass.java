package com.task.seven;

import com.task.seven.brackets.Brackets;

import java.io.FileInputStream;
import java.io.IOException;

public class ThreadClass extends Thread {
    private final static String FILE_NAME = "brackets.txt";

    public ThreadClass(String s) {
        this.setName(s);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        new Brackets(this.readFromFile()).start();
    }

    private String readFromFile() {
        StringBuilder str = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                str.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(str);
    }
}
