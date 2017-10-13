package com.tutorial.test.unit;

import com.tutorial.domain.User;
import com.tutorial.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by jimmy on 2017/10/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest/*(classes = App.class)*/
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        User user = new User();
        user.setUserName("lucy2");
        user.setPassWord("123");
        user.setInCome(100L);
        user.setUserDesc("描述");
        user.setAddress("wuxi");
        user.setBirthDay(new Date());
        userService.saveOrUpdate(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("jimmy");
        user.setPassWord("123456");
        user.setInCome(100L);
        user.setUserDesc("描述11111111111111111222222222222222333333333333333333333");
        user.setAddress("wuxi");
        user.setBirthDay(new Date());
        userService.saveOrUpdate(user);
    }
}
