package com.task.eight.brackets;

import com.task.eight.annotation.Singleton;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Singleton
public class BracketsImpl implements Brackets {
    private List<String> result;
    private String str;

    public BracketsImpl() {
        result = new ArrayList<>();
    }

    @Override
    public void start(String str) {
        this.str = str;
        try {
            if (checkBrackets()) {
                System.out.println(str + "\n" + "The brackets are placed correctly\n");
            } else {
                throw new IncorrectBrackets();
            }
        } catch (IncorrectBrackets ex) {
            System.out.println(str);
            ex.printStackTrace();
        }
    }

    private boolean checkBrackets() {
        List<String> test;
        if ((test = filterString()).size() < 2) {
            return false;
        }
        test.forEach(s -> {
            if (s.equals("<") || s.equals("{") || s.equals("(") || s.equals("[")) {
                result.add(s);
            } else if (result.size() - 1 < 0) {
                result.add("#");
            } else {
                String str = result.get(result.size() - 1);
                if ((str.equals("<") && s.equals(">"))
                        || (str.equals("[") && s.equals("]"))
                        || (str.equals("{") && s.equals("}"))
                        || (str.equals("(") && s.equals(")"))) {
                    result.remove(result.size() - 1);
                }
            }
        });
        return result.size() == 0;//check the same number of opening and closing brackets
    }

    private List<String> filterString() {
        return Arrays.stream(str.split(""))
                .parallel()
                .filter(str1 -> str1.equals("<")
                        || str1.equals(">")
                        || str1.equals("{")
                        || str1.equals("}")
                        || str1.equals("(")
                        || str1.equals(")")
                        || str1.equals("[")
                        || str1.equals("]"))
                .collect(Collectors.toList());
    }
}
