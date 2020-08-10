package com.example.chong.activity_write.utils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 21.2.3   1   构造器方法：executors.newCachedThreadPool();
 * CachedThreadPool 为每个任务都创建一个线程
 *
 * ExecetorService 是具有服务生命周期的 Executor,知道如何构建恰当的上下文来执行 Runnable对象
 * 注意，ExecutorService 对象是使用静态的 Executor方法创建的，这个方法可以确定其 Executor类型
 *
 *
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //executors调用不同的静态方法，可以生成不同类型的Executor
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();

    }
}
