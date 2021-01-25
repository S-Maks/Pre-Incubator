package com.task.eight;

import com.task.eight.brackets.Brackets;
import com.task.eight.brackets.BracketsImpl;
import com.task.eight.reflection.Application;
import com.task.eight.reflection.ApplicationContext;
import com.task.eight.reflection.ObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("Start task 8");
        ThreadClass threadClass;
        for (int i = 0; i < 1; i++) {
            ApplicationContext context = Application.run("com", new HashMap<>(Map.of(Brackets.class, BracketsImpl.class)));
            threadClass = context.getObject(ThreadClass.class);
            threadClass.start();
        }
    }
}
