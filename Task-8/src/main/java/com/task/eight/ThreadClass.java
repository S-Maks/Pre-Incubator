package com.task.eight;

import com.task.eight.annotation.Autowired;
import com.task.eight.brackets.Brackets;
import com.task.eight.brackets.BracketsImpl;
import com.task.eight.reflection.ObjectFactory;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ThreadClass extends Thread {
    private final static String FILE_NAME = "brackets.txt";

    @Autowired
    private Brackets brackets;

    public ThreadClass() {
    }

    @Override
    public void start() {
        super.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        brackets.start(this.readFromFile());
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
