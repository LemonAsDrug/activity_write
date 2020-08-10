package com.example.chong.activity_write.exp;

public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        }catch (MyException e){
//            e.printStackTrace();//输出标准错误流
            e.printStackTrace(System.out);//错误信息照样输出，字体从红色变成白色
        }
        try {
            g();
        }catch (MyException e){
//            e.printStackTrace();//输出标准错误流
            e.printStackTrace(System.out);//错误信息照样输出，字体从红色变成白色
        }

    }
}
