package com.task.eight.reflection.configurator;

import com.task.eight.reflection.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
