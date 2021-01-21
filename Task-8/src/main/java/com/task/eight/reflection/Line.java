package com.task.eight.reflection;

import javassist.NotFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Line {
    public static void checkLine(Object ob) throws IllegalAccessException, NoSuchMethodException, InstantiationException, NotFoundException, InvocationTargetException {
        Class<?> classes = ob.getClass();
        for (Field field : classes.getDeclaredFields()) {
            if (field.isAnnotationPresent(com.task.eight.annotation.Line.class) && (field.getType() == String.class)) {
                field.setAccessible(true);
                new Application((String) field.get(ob)).start();
            }
        }
    }
}
