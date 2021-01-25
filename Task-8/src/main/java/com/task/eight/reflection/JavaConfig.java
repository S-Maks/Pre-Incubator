package com.task.eight.reflection;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections reflections;
    private Map<Class,Class> ifcImplClass;

    public JavaConfig(String packageScan,Map<Class,Class> ifcImplClass) {
        this.ifcImplClass = ifcImplClass;
        this.reflections = new Reflections(packageScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifcImplClass.computeIfAbsent(ifc,aClass -> {
            Set<Class<? extends T>> classSet = reflections.getSubTypesOf(ifc);
            if(classSet.size()!=1){
                throw new RuntimeException(ifc + " has 0 or more than one impl");
            }
            return classSet.iterator().next();
        });
    }
}
