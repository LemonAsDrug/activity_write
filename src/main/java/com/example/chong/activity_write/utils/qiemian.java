package com.example.chong.activity_write.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class qiemian {
    //匹配所有ServiceImpl包下面的所有类的所有方法
    @Pointcut("execution(* com.example.chong.activity_write.service.impl.*.*(..))")
    public void addLog(){
        System.out.println("before");
    }


    //@Pointcut("execution(* com.example.chong.activity_write.service.impl.*.*(..))")
    public void skipMethod(){}



}
