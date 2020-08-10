package com.example.chong.activity_write.utils.thread;

/**
 *  21.2.1 定义任务
 *  线程可以驱动任务，因此你需要一种描述任务的方式，这可以由Runnable接口来提供。
 *  要想定义任务，只需实现 Runnable 接口并编写 run()方法，使得该任务可以执行你的命令。
 */
public class LiftOff implements Runnable{

    protected int countDown = 10;

    private static int taskCount = 0;

    /**
     * 常量不会改变
     * 用来区分任务的多个实例
     */
    private final int id = taskCount++;


    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + ":" + (countDown > 0 ? countDown:"LiftOff!") +",";

    }

    @Override
    public void run() {
        while (countDown --> 0){
            System.out.println(status());

            /**
             * Thread.yield()的调用是对 ”线程调度器 “ 的一种建议，它在声明 ”我已经执行完生命周期中最
             * 重要的部分了，此刻正是切换给其他任务执行一段时间的大好时机。“
             */
            Thread.yield();
        }

    }

}
