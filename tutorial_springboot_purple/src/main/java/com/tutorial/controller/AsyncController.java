package com.tutorial.controller;

import com.tutorial.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by jimmy on 2017/11/3.
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("asyncTest")
    public String asyncTest() throws InterruptedException {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        TimeUnit.SECONDS.sleep(10);
        return "hello_111";
    }
}
