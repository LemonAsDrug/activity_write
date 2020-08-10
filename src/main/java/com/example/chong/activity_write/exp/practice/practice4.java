package com.example.chong.activity_write.exp.practice;


class practice4Exception extends Exception{
    public practice4Exception(){};

    public practice4Exception(String msg){
        super(msg);//不调用父类的构造器，报错信息后，不会带有传入的字符串
        String s = msg;
    }
}

class person2{
    public static void  p(String str) throws practice4Exception{
        System.out.println("string = " + str);
        throw new practice4Exception(str);
    }

}
public class practice4{
    public static void main(String[] args) {
        try {
            person2.p("测试异常");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}

