package com.task.eight.reflection;

import com.task.eight.Main;
import com.task.eight.annotation.BracketsAnnotation;
import javassist.NotFoundException;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Application {
    private final String namePackage;
    private final String brackets;

    public Application(String brackets) {
        namePackage = Main.class.getPackage().getName();
        this.brackets = brackets;
    }

    public void start() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NotFoundException {
        Object ob;
        Reflections scanner = new Reflections(namePackage);
        Set<Class<?>> classes = scanner.getTypesAnnotatedWith(BracketsAnnotation.class);
        if (classes.size() != 1) {
            throw new RuntimeException("constructors more one or not found");
        } else {
            ob = createObject(classes);
        }
        Method method = findMethod(classes);
        method.invoke(ob);
    }

    private Object createObject(Set<Class<?>> classes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return classes.iterator().next().getConstructor(String.class).newInstance(brackets);
    }

    private Method findMethod(Set<Class<?>> classes) throws NotFoundException {
        for (Method method : classes.iterator().next().getMethods()) {
            if (method.isAnnotationPresent(BracketsAnnotation.class)) {
                return method;
            }
        }
        throw new NotFoundException("method not found");
    }
}
