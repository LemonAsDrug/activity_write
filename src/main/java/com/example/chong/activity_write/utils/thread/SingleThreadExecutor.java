package com.example.chong.activity_write.utils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 21.2.3   3 构造器方法 executors.newSingleThreadExecutor();
 * 本类 像是线程数量为 1 的 FixedThreadPool
 *
 * 如果向SingleThreadExecutor 提交了多个任务，那么这些任务将排队
 * 每个任务都会在下一个任务开始之前运行结束，所有的任务将使用相同的线程。
 *
 * SingleThreadExecutor会序列化所有提交给它的任务，并会维护它自己（隐藏）的悬挂任务队列。
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();

    }
}
