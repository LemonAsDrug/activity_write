package com.example.chong.activity_write.utils.thread;

/**
 * 21.2.2 Thread类
 * 可以添加更多的线程去驱动更多的任务，
 * 下面你可以看到所有任务彼此之间是如何互相呼应的。
 */
public class BasicMoreThreads {
    public static void main(String[] args) {
        System.out.println("LiftOff starting:");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
    }
}
