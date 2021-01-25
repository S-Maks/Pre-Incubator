package com.task.eight.model;

import com.task.eight.annotation.Line;
import com.task.eight.annotation.Text;
import lombok.Data;

@Data
@Deprecated
public class BookImpl implements Book{
    @Line
    private String name;

    public BookImpl() {
        name = "[3] - Wikipedia";
    }

    @Override
    @Text
    public String someText() {
        return "На половине перегона лес кончился, и с боков открылись елани (поля)... (Л. Толстой)";
    }
}
