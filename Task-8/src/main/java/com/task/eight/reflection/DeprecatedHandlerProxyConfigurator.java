package com.task.eight.reflection;

import com.task.eight.annotation.Autowired;
import com.task.eight.annotation.Singleton;
import com.task.eight.annotation.Text;
import com.task.eight.brackets.Brackets;
import com.task.eight.brackets.BracketsImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {

    @Autowired
    private Brackets brackets;

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            Set<String> methods = new HashSet<>();
            for (Method method : implClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Text.class)) {
                    methods.add(method.getName());
                }
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> {
                if (methods.contains(method.getName())) {
                    new BracketsImpl().start((String) method.invoke(t));
                    brackets.start((String) method.invoke(t));
                }
                return method.invoke(t);
            });
        } else {
            return t;
        }
    }
}
