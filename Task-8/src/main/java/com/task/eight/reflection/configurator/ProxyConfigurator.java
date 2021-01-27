package com.task.eight.reflection.configurator;

import com.task.eight.reflection.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass, ApplicationContext context) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException;
}
