package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by jimmy on 2017/10/25.
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
//@ServletComponentScan
public class PurpleApp {
    public static void main(String[] args) {
        SpringApplication.run(PurpleApp.class,args);
    }

    @Bean
    public Object transactionBean(PlatformTransactionManager platformTransactionManager){
        System.out.println("当前使用的事务管理器:" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}
