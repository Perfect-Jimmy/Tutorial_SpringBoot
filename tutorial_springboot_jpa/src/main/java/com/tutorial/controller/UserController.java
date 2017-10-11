package com.tutorial.controller;

import com.tutorial.domain.User;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jimmy on 2017/10/11.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save",method = {RequestMethod.POST,RequestMethod.GET})
    public void saveUser(){
        User user = new User();
        user.setUserName("hh");
        user.setPassWord("123");
        userService.saveOrUpdate(user);
    }
}
