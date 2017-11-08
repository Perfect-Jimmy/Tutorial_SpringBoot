package com.tutorial.configuration;

import com.tutorial.utils.ThreadPoolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jimmy on 2017/11/8.
 */
@Component
public class ThreadPoolConfiguration {

    @Autowired
    private ThreadPoolParam threadPoolParam;

    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolParam.getCorePoolSize());
        executor.setMaxPoolSize(threadPoolParam.getMaxPoolSize());
        executor.setQueueCapacity(threadPoolParam.getQueueCapacity());
        executor.setKeepAliveSeconds(threadPoolParam.getKeepAliveSeconds());
        executor.setThreadNamePrefix("MyExecutor-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        System.out.println(executor);
        return executor;
    }
}
