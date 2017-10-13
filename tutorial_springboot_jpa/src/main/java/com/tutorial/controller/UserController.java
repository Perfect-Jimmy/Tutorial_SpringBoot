package com.tutorial.controller;

import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jimmy on 2017/10/11.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


}
