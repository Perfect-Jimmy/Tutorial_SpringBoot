package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by jimmy on 2017/10/25.
 */
@SpringBootApplication
@EnableAsync
//@ServletComponentScan
public class PurpleApp {
    public static void main(String[] args) {
        SpringApplication.run(PurpleApp.class,args);
    }
}
