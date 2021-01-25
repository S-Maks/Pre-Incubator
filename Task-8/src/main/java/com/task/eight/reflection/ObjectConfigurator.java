package com.task.eight.reflection;

import java.lang.reflect.InvocationTargetException;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context ) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
