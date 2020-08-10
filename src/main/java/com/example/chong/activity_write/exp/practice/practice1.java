package com.example.chong.activity_write.exp.practice;

public class practice1 {

    public static void main(String[] args) {
        try {
            //抛出异常要可以写在异常说明的方法体里面（没异常说明的方法，方法里没法抛异常）
            //或者代码、代码块里，但要确保被捕捉到了
            throw new Exception("测试异常");
        }catch (Exception e){ //捕捉到了 引用名为e的 Exception 异常
            e.printStackTrace(System.out);
        }finally {
            System.out.println("终于结束了");
        }
    }
}
