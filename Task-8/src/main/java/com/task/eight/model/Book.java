package com.task.eight.model;

import com.task.eight.annotation.Line;
import com.task.eight.annotation.Text;
import lombok.Data;

@Data
public class Book {
    @Line
    private String name;

    public Book() {
        name = "[3] - Wikipedia";
    }

    @Text
    private String someText() {
        return "На половине перегона лес кончился, и с боков открылись елани (поля)... (Л. Толстой)";
    }
}
