package com.task.eight;

import com.task.eight.annotation.MyAnno;
import com.task.eight.brackets.Brackets;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.Arrays;

public class ThreadClass extends Thread {
    private final static String FILE_NAME = "brackets.txt";

    public ThreadClass(String s) {
        this.setName(s);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        try{
            Class<?> cl1 = Class.forName("com.task.eight.brackets.Brackets");
            if(cl1.isAnnotationPresent(MyAnno.class)){
               Object ob = cl1.getConstructor(String.class).newInstance(this.readFromFile());
                Method[] method = cl1.getMethods();
                for (Method met: method) {
                    if(met.isAnnotationPresent(MyAnno.class)){
                        met.invoke(ob);
                    }
                }
            }
        }catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException ex){
            System.out.println(Arrays.toString(ex.getStackTrace()));
        } catch (NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }

        //new Brackets(this.readFromFile()).start();
    }

    private String readFromFile(){
        StringBuilder str = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            int i;
            while((i = fileInputStream.read())!=-1){
                str.append((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(str);
    }
}
