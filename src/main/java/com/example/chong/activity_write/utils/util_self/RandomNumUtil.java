package com.example.chong.activity_write.utils.util_self;

public class RandomNumUtil {

    /**
     * 生成一个 1- num 之间的整数(包括 1、num)
     * @param num
     * @return
     */
    public static Long getRandomNum(Integer num){
     Long a = (Math.round(Math.random()*(num-1)+1));
     return  a;
    }

    /**
     * 生成一个 num1 - num2 之间的随机数（包括 num1、num2）
     * num1、num2为正整数
     * @param num1
     * @param num2
     * @return
     */
    public static Long getBetweenRandomNum(Integer num1,Integer num2){
        Long top = (Math.round(Math.random()*(num2-1)+1));
        Long end = num1 + Math.round(Math.abs(top-num1)*Math.random());
        return end;
    }

}
