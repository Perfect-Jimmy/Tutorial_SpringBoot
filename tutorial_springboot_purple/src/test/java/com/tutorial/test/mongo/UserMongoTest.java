package com.tutorial.test.mongo;

import com.tutorial.domain.User;
import com.tutorial.mongo.service.UserMongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jimmy on 2017/10/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserMongoTest {
    @Autowired
    private UserMongoService userMongoService;

    @Test
    public void saveUserTest(){
        User user = new User();
        user.setId(1L);
        user.setUserName("Jimmy");
        user.setAddress("wuxi");
        userMongoService.saveUser(user);
    }
}
