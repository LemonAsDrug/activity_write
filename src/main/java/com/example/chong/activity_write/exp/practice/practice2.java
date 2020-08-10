package com.example.chong.activity_write.exp.practice;

import lombok.Data;

@Data
class person {

    private String name;

}

public class practice2 {
    public static void main(String[] args) {
        try {
            person person2 = null;
            person2.getName();
//            person2.test();//person调用方法，抛出了异常
//            throw new Exception("空指针异常");//这行代码不会生效，try块已经抓住了NEP的异常
        }catch (Exception e){
            e.printStackTrace(System.out);
        }

    }

}
