package com.task.eight.reflection;

import com.task.eight.Main;
import com.task.eight.annotation.Autowired;
import com.task.eight.brackets.Brackets;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectFactory {
    private final ApplicationContext context;
    private final List<ObjectConfigurator> configuratorList = new ArrayList<>();
    private final List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getReflections().getSubTypesOf(ObjectConfigurator.class)) {
            configuratorList.add(aClass.getDeclaredConstructor().newInstance());
        }
        for (Class<? extends ProxyConfigurator> aClass : context.getConfig().getReflections().getSubTypesOf(ProxyConfigurator.class)) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public <T> T createObject(Class<T> implClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T t = create(implClass);
        configure(t);
        t = wrapWithProxyIfNeeded(implClass, t);
        return t;
    }

    private <T> T wrapWithProxyIfNeeded(Class<T> implClass, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.replaceWithProxyIfNeeded(t, implClass);
        }
        return t;
    }

    private <T> void configure(T t) {
        configuratorList.forEach(objectConfigurator -> {
            try {
                objectConfigurator.configure(t, context);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    @NotNull
    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        T t = implClass.getDeclaredConstructor().newInstance();
        return t;
    }
}
