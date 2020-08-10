package com.example.chong.activity_write.utils.thread;

/**
 * 21.2.1 定义任务
 */
public class MainThread {
    /**
     * 在这里， 任务LiftOff任务的run()方法不是由单独的线程驱动的，它是在 main 方法中直接调用的
     * 实际上，这里仍旧使用了线程，即总是分配给main()的那个线程
     * @param args
     */
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
