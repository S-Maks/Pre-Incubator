package com.tast.one;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class Brackets {
    private List<Character> result;

    Brackets() {
        result = new ArrayList<>();
    }

    public void start() {
        if (checkBrackets()) {
            System.out.println("The brackets are placed correctly");
        } else {
            System.out.println("The brackets are placed incorrectly");
        }
    }

    private boolean checkBrackets() {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an array of parentheses");
        str = scanner.nextLine();//reading a line from the console
        char[] strArr = String.join("", str.split(",")).toCharArray();//split the string and convert it to an array of characters
        for (char s : strArr) {
            if (s == '<' || s == '(' || s == '{' || s == '[') {
                result.add(s);//add the opening bracket
            } else {
                if (!this.popToArray(s)) {//remove the closing bracket
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
