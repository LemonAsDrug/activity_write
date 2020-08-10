package com.example.chong.activity_write.utils.thread.test;

import com.example.chong.activity_write.utils.thread.LiftOff;

import java.util.concurrent.TimeUnit;

public class asdasdasd {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("1");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("2");

    }
}
