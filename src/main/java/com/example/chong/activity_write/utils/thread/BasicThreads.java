package com.example.chong.activity_write.utils.thread;

/**
 * 21.2.2 Thread类
 * 不用这种方式，用 执行器 executor管理 Thread对象
 * Executor 允许管理异步方法的执行，而无须显式地管理线程的生命周期。
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.run();
        System.out.println("LiftOff starting:");
    }
}
