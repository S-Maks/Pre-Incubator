package com.task.fife.brackets;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Brackets {
    private static List<Character> result;

    private String str;

    public Brackets(String str) {
        this.str = str;
        result = new ArrayList<>();
    }

    public void start() {
            try {
                if (checkBrackets()) {
                    System.out.println("The brackets are placed correctly");
                } else {
                    throw new IncorrectBrackets();
                }
            }catch (IncorrectBrackets ex){
                ex.printStackTrace();
            }
    }

    private boolean checkBrackets() {
        char[] strArr = String.join("", str.split(",")).toCharArray();//split the string and convert it to an array of characters
        for (char s : strArr) {
            if (s == '<' || s == '(' || s == '{' || s == '[') {
                result.add(s);//add the opening bracket
            } else {
                if (!this.popToArray(s)) {//remove the opening bracket
                    return false;
                }
            }
        }
        return result.size() == 0;//check the same number of opening and closing brackets
    }

    private boolean popToArray(char s) {
        if (result.size() - 1 < 0) {//check for opening brackets
            return false;
        }
        switch (result.get(result.size() - 1)) {//remove the corresponding bracket
            case '<':
                if (s == '>') {
                    result.remove(result.size() - 1);
                    return true;
                } else {
                    return false;
                }
            case '[':
                if (s == ']') {
                    result.remove(result.size() - 1);
                    return true;
                } else {
                    return false;
                }
            case '{':
                if (s == '}') {
                    result.remove(result.size() - 1);
                    return true;
                } else {
                    return false;
                }
            case '(':
                if (s == ')') {
                    result.remove(result.size() - 1);
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    }
}
