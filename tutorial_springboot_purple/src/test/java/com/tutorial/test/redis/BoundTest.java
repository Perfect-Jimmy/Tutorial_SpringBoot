package com.tutorial.test.redis;

import com.tutorial.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jimmy on 2017/10/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class BoundTest {
    @Autowired
    private RedisTemplate jsonRedisTemplate;

    @Test
    public void boundValueTest(){
        BoundValueOperations<String, User> ops = jsonRedisTemplate.boundValueOps("User:古");
        System.out.println(ops.get());
    }

    @Test
    public void boundHashTest(){
        BoundHashOperations<String, String, String> ops = jsonRedisTemplate
                .boundHashOps("hash");
        System.out.println(ops.keys());
    }

    @Test
    public void boundListTest(){
        BoundListOperations<String,String> ops = jsonRedisTemplate.boundListOps("list_index");
        System.out.println(ops.range(0,-1));
    }

    @Test
    public void boundSetTest(){
        BoundSetOperations<String,String> ops = jsonRedisTemplate.boundSetOps("random_set");
        System.out.println(ops.members());
    }

    @Test
    public void boundZSetTest(){
        BoundZSetOperations<String,String> ops = jsonRedisTemplate.boundZSetOps("count_zset");
        System.out.println(ops.range(0,-1));
    }
}
