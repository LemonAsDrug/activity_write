package com.example.chong.activity_write.utils.util_self;

import java.util.ArrayList;

public class Collections {

    /**
     * 测试 RandomNumUtil 工具类
     * 大的 Long 型数值会失效，找杨允进的方法
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Long> longs = new ArrayList<Long>();
        for (int i = 0; i < 1000 ; i++) {
            Long randomNum = RandomNumUtil.getBetweenRandomNum(6,100);
            longs.add(randomNum);
            System.out.println(randomNum);
        }
        System.out.println("__________________");
        System.out.println(java.util.Collections.max(longs));
        System.out.println(java.util.Collections.min(longs));
    }
}
