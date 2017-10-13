package com.tutorial.test.unit;

import com.tutorial.domain.User;
import com.tutorial.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
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
    public void saveUserTest(){
        User user = new User();
        user.setUserName("Jimmy");
        user.setPassword("123");
        user.setInCome(100L);
        user.setUserDesc("描述");
        user.setAddress("wuxi");
        user.setBirthDay(new Date());
        userService.saveOrUpdate(user);
    }

    @Test
    public void updateUserTest(){
        User user = new User();
        user.setId(1L);
        user.setUserName("jimmy");
        user.setPassword("123456");
        user.setInCome(100L);
        user.setUserDesc("描述11111111111111111222222222222222333333333333333333333");
        user.setAddress("wuxi");
        user.setBirthDay(new Date());
        userService.saveOrUpdate(user);
    }

    @Test
    public void findByUserNameAndPasswordTest(){
        System.out.println(userService.findByUserNameAndPassword("jimmy","123456"));
    }

    @Test
    public void findByUserNameOrPasswordTest(){
        System.out.println(userService.findByUserNameOrPassword("lucy","123456").size());
    }

    @Test
    public void countByUserNameTest(){
        System.out.println(userService.countByUserName("jimmy"));
    }

    @Test
    public void findByUserNameLikeTest(){
        System.out.println(userService.findByUserNameLike("lucy"));
    }

    @Test
    public void findByUserNameIgnoreCaseTest(){
        System.out.println(userService.findByUserNameIgnoreCase("jimmy"));
    }

    @Test
    public void findByUserNameTest(){
        System.out.println(userService.findByUserName("jimmy"));
    }

    @Test
    public void findByUserNameOrderByBirthDayDescTest(){
        System.out.println(userService.findByUserNameOrderByBirthDayDesc("jimmy"));
    }

    @Test
    public void pageByUserNameTest(){
        Page<User> page = userService.pageByUserName(0,2,"jimmy");
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getContent());
    }

    @Test
    public void modifyUserTest(){
        userService.modifyUser("Jack1",6L);
    }

    //TODO
    @Test
    public void modifyUser1Test(){
        User user = userService.findById(6L);
        user.setUserName("jk");
        userService.modifyUser(user);
    }

    @Test
    public void queryUserByParamTest(){
        Page<User> page = userService.queryUserByParam("jimmy",1,2);
        System.out.println(page.getContent());
    }
}

