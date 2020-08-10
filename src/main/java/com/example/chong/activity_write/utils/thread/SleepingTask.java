package com.example.chong.activity_write.utils.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 21.2.5   休眠
 * sleep()方法的作用：使任务中止，停止指定的时间后，继续执行下面的内容
 */
public class SleepingTask extends LiftOff{
    @Override
    public void run() {
        try{
            while(countDown-- > 0){
                System.out.println(status());
                System.out.println("1");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("2");
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SleepingTask());
            //线程池中的线程同时运行，每次执行5次任务，睡眠一次，再执行5次任务，依次类推
        }
        executorService.shutdown();
    }
}
