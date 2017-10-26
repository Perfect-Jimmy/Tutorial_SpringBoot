package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jimmy on 2017/10/25.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

    @RequestMapping("/testServlet/test")
    public String testServlet(){
        return "hello-servlet";
    }

    @RequestMapping("/user/test")
    public String userAuthTest(){
        return "hello-user";
    }
}
