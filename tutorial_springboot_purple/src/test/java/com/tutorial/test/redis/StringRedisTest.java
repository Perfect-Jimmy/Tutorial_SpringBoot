package com.tutorial.test.redis;

import com.tutorial.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by jimmy on 2017/10/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class StringRedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate objSeriesRedisTemplate;
    @Autowired
    private RedisTemplate jsonRedisTemplate;

    @Test
    public void connectTest(){
        //stringRedisTemplate.opsForValue().set("zzp","big z");
        stringRedisTemplate.opsForValue().set("zzp","hello");
    }


    @Test
    public void saveUserTest(){
        User user = new User();
       /* user.setId(1L);
        user.setUserName("刘德华");
        user.setAddress("Hongkong");
        user.setBirthDay(new Date());*/

        user.setUserName("黎明");
        user.setAddress("Hongkong");
        user.setBirthDay(new Date());
        objSeriesRedisTemplate.opsForValue().set("User",user);
    }

    @Test
    public void objToStringTest(){
        ValueOperations<String,User> operations = jsonRedisTemplate.opsForValue();
        User user = new User();
        user.setUserName("古XX1");
        user.setAddress("Hongkong");
        user.setBirthDay(new Date());
        operations.set("User:古1",user);

        User user1 = new User();
        user1.setId(200L);
        user1.setUserName("古XX");
        user1.setAddress("Hongkong");
        user1.setBirthDay(new Date());
        operations.set("User:古",user1);
    }
}
