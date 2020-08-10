package com.example.chong.activity_write.utils.thread;

import java.util.concurrent.Callable;

/**
 * 21.2.4   1
 * 从任务中产生返回值
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult： " + id;
    }
}
