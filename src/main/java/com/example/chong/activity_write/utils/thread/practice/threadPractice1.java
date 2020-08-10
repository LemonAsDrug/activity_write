package com.example.chong.activity_write.utils.thread.practice;

/**
 * p656 练习1
 */
public class threadPractice1 implements Runnable {

    protected int count = 10;

    public static int taskCount = 0;

    public final int id = taskCount++;

    public threadPractice1( ) {
        System.out.println("threadPractice1 starting...");
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("#id:" + id +",times:"+i+"");
        }
        Thread.yield();
    }
}

class test1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new threadPractice1());
            thread.start();
        }
    }
}