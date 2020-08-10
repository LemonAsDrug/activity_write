package com.example.chong.activity_write.utils.thread;


import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{


    public SimpleDaemons() {
    }

    @Override
    public void run() {
        try {
            while(true){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + " " + this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }


}
class testsimple{
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDaemons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("all deamons started");
        TimeUnit.SECONDS.sleep(5);
//        TimeUnit.SECONDS.sleep() 写在哪个线程里，哪个线程才会休眠
    }
}
