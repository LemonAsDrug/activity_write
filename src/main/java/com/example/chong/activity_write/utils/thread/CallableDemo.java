package com.example.chong.activity_write.utils.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 21.2.4   2
 * exec.submit()方法会产生 Future 对象，future.get() 获取任务的结果
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results){
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                e.printStackTrace();
                return;
            }catch (ExecutionException e){//不抓这个错，fs.get编译不通过
                System.out.println(e);
            }finally {
                exec.shutdown();
            }

        }
    }
}
