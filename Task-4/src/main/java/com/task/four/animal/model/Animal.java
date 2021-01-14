package com.task.four.animal.model;

import lombok.Data;

@Data
public abstract class Animal {
    protected String name;

    abstract public String voice();
}
