package com.task.eight.model;

import com.task.eight.annotation.Text;

@Deprecated
public class PageImpl implements Page {
    @Override
    @Text
    public String text() {
        return "<S>()";
    }
}
