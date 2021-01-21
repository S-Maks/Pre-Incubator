package com.task.eight;

import com.task.eight.model.Book;
import com.task.eight.reflection.Application;
import com.task.eight.reflection.Line;
import com.task.eight.reflection.Text;
import lombok.SneakyThrows;

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

    @SneakyThrows
    @Override
    public void run() {
        new Application(this.readFromFile()).start();
        Book book = new Book();
        Line.checkLine(book);
        Text.checkText(book);
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
