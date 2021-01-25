package com.task.eight.reflection;

import com.task.eight.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AutowiredObjectConfigurator implements ObjectConfigurator {
    @Override
    public void configure(Object t, ApplicationContext context) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                System.out.println("Hello world!");
                field.setAccessible(true);
                Object ob = context.getObject(field.getType());
                field.set(t, ob);
            }
        }
    }
}