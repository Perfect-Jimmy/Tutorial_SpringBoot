package com.tutorial.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by jimmy on 2017/11/3.
 * 1. 主类添加 @EnableAsync
 * 2. 方法添加 @Async
 */
@Component
public class AsyncTask {

    @Async  //加入"异步调用"注解
    public void doTaskOne() throws InterruptedException {
        System.out.println("开始执行任务一");
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async  //加入"异步调用"注解
    public void doTaskTwo() throws InterruptedException {
        System.out.println("开始执行任务二");
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(7);
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }
}
