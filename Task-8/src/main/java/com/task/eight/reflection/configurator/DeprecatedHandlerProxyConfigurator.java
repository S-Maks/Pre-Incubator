package com.task.eight.reflection.configurator;

import com.task.eight.annotation.Text;
import com.task.eight.brackets.Brackets;
import com.task.eight.reflection.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    private Brackets brackets;

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass, ApplicationContext context) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            brackets = context.getObject(Brackets.class);
            Set<String> methods = new HashSet<>();
            for (Method method : implClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Text.class)) {
                    methods.add(method.getName());
                }
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> {
                if (methods.contains(method.getName())) {
                    brackets.start((String) method.invoke(t));
                }
                return method.invoke(t);
            });
        } else {
            return t;
        }
    }
}
