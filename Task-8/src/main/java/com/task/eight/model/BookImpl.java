package com.task.eight.model;

import com.task.eight.annotation.Autowired;
import com.task.eight.annotation.Line;
import com.task.eight.annotation.Text;
import com.task.eight.brackets.Brackets;
import lombok.Data;
import lombok.Setter;

@Data
@Deprecated
public class BookImpl implements Book{
    @Line
    @Setter
    private String name;

    @Autowired
    private Page page;

    public BookImpl() {
    }

    @Override
    public String someText() {
       return page.text();
    }
}
