package com.example.chong.activity_write.utils.timed_task;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class p{
    static void get(){
        System.out.println("test："+ new Date());
    }
}
public class TestScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(
                ()-> System.out.println("task ScheduledExecutorService:"+new Date()),
                5,2, TimeUnit.SECONDS);
//        ()->person.get(),指定方法 也可
        service.scheduleAtFixedRate(
                ()-> p.get(),
                5,2, TimeUnit.SECONDS);
    }
}
