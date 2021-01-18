package com.task.four.brackets;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class Brackets {
    private List<Character> result;

    private String str;

    public Brackets(String str) {
        this.str = str;
        result = new ArrayList<>();
    }

    public void start() {
            try {
                if (checkBrackets()) {
                    System.out.println(str + "\n" + "The brackets are placed correctly");
                } else {
                    throw new IncorrectBrackets();
                }
            }catch (IncorrectBrackets ex){
                System.out.println(str);
                ex.printStackTrace();
            }
    }

    private boolean checkBrackets() {
        char[] strArr = filterString();//split the string and convert it to an array of characters
        if (strArr.length < 2) {
            return false;
        }
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

    private char[] filterString() {
        StringBuilder resultString = new StringBuilder();
        for (char s : String.join("", str.split(",")).toCharArray()) {
            if (s == '<' || s == '('
                    || s == '{' || s == '['
                    || s == '>' || s == ')'
                    || s == '}' || s == ']') {
                resultString.append(s);
            }
        }
        return String.valueOf(resultString).toCharArray();
    }
}
