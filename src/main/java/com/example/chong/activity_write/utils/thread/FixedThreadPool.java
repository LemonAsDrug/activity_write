package com.example.chong.activity_write.utils.thread;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 21.2.3   2   构造器方法 Executors.newFixedThreadPool
 * 本类使用了有限的线程集来执行所提交的任务
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        //Executors调用不同的静态方法，生成不同类型的Executor
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        //shutdown方法的调用可以防止新任务被提交给这个Executor
        //当前线程将继续运行在shutdown()被调用之前提交的所有任务
    }
}
