package com.example.chong.activity_write.utils.javabok_annotest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 简单的注解处理器
 * 目的:读取 PasswordUtils类，并使用反射机制查找 @UseCase标记
 *      我们为其提供了一组id值，然后它会列出在PasswordUtils 中找到的用例，以及缺失的用例
 */
public class UserCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc!=null) {
                System.out.println("Found Use Case:" + uc.id() + " ,description:" + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases){
            System.out.println("Warning : Missing use case - " + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);//将所有指定的元素添加到指定的集合中。
        trackUseCases(useCases,PasswordUtils.class);

    }
}
