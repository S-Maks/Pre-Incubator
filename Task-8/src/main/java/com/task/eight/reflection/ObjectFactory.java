package com.task.eight.reflection;

import com.task.eight.Main;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectFactory {
    private ApplicationContext context;
    private List<ObjectConfigurator> configuratorList = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getReflections().getSubTypesOf(ObjectConfigurator.class)) {
            configuratorList.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public <T> T createObject(Class<T> implClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        T t = implClass.getDeclaredConstructor().newInstance();

        configuratorList.forEach(objectConfigurator -> {
            try {
                objectConfigurator.configure(t,context);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return t;
    }
}
