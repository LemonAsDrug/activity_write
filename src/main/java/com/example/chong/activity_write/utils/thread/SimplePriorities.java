package com.example.chong.activity_write.utils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 21.2.6
 * 优先级
 *  线程的优先级由调度器决定，尽管cpu处理现有线程集的顺序是不确定的，
 *  但是调度器将倾向于让优先级最高的线程先执行。
 *  优先权不会导致死锁。（即优先权较低的线程得不到执行）
 *  优先级较低的线程仅仅是执行的频率较低。
 *
 *  在绝大多数时间里，所有线程都应该以默认的优先级执行。
 *  重点：试图操纵线程优先级是一种错误。
 */
public class SimplePriorities implements Runnable{
    private int countDown = 5;

    private volatile double d;

    private int priorrity; //priority 翻译 优先级

    public SimplePriorities(int priorrity) {
        this.priorrity = priorrity;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" +countDown;
        //Thread.currentThread(): 返回对当前执行线程对象的引用。
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priorrity);
        while(true){
            for (int i = 1; i < 100000 ;i++){
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 ==0)
                    Thread.yield();
            }
            System.out.println(this);//默认调用toString方法
            if (--countDown == 0) return ;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
            executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        }
        executorService.shutdown();

    }
}
