package com.task.eight.reflection;

import com.task.eight.annotation.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ObjectFactory objectFactory;
    private final Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private final Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(cache.containsKey(type)){
            return (T) cache.get(type);
        }
        Class<? extends T> implClass = type;
        if (implClass.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t =  objectFactory.createObject(implClass);
        if(implClass.isAnnotationPresent(Singleton.class)){
            cache.put(type,t);
        }
         return t;
    }
}
