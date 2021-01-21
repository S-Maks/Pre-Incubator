package com.task.eight.reflection;

import javassist.NotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Text {
    public static void checkText(Object ob) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NotFoundException, InstantiationException {
        Class<?> classes = ob.getClass();
        for (Method method : classes.getDeclaredMethods()) {
            if (method.isAnnotationPresent(com.task.eight.annotation.Text.class) && (method.getReturnType() == String.class)) {
                method.setAccessible(true);
                new Application((String) method.invoke(ob)).start();
            }
        }
    }
}
