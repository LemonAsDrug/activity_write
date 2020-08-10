package com.example.chong.activity_write.exp.practice;


class practice5Exception extends Exception{
    public practice5Exception(){};

    public practice5Exception(String msg){
        super(msg);
    }
}

class person3{
    public static void  p(String msg) throws practice4Exception{
        throw new practice4Exception(msg);
    }

}
public class practice5{
    public static void main(String[] args) {
        int a = 3;
        while(a++ < 10){
            try {
                person3.p("测试异常");
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        //a为9时，循环进行，a为10时 条件不成立，从循环出来。

    }

}
