package com.tutorial.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * Created by jimmy on 2017/10/30.
 * Set是string类型的无序集合
 * 集合成员是唯一的，这就意味着集合中不能出现重复的数据。
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class SetRedisTest {
    @Autowired
    private RedisTemplate jsonRedisTemplate;

    /**
     * 添加数据Long add(K key, V... values);
     */
    @Test
    public void saveTest(){
        String[] array = StringUtils.delimitedListToStringArray("set1,set1,set2,set3",",");
        jsonRedisTemplate.opsForSet().add("save_set",array);
    }

    /**
     * 移除集合中一个或多个成员 Long remove(K key, Object... values);
     */
    @Test
    public void removeTest(){
        String[] array = StringUtils.delimitedListToStringArray("set1,set1,set2,set3",",");
        jsonRedisTemplate.opsForSet().add("remove_set",array);
        jsonRedisTemplate.opsForSet().remove("remove_set","set2","set3");
    }

    /**
     * 移除并返回集合中的一个随机元素 V pop(K key);
     */
    @Test
    public void popTest(){
        String[] array = StringUtils.delimitedListToStringArray("set1,set1,set2,set3",",");
        jsonRedisTemplate.opsForSet().add("pop_set",array);
        jsonRedisTemplate.opsForSet().pop("pop_set");
        System.out.println(jsonRedisTemplate.opsForSet().members("pop_set"));
    }

    /**
     * 元素从source集合移动到destination集合 Boolean move(K source, V value, K destKey);
     */
    @Test
    public void moveTest(){
        String[] array = StringUtils.delimitedListToStringArray("set1,set1,set2,set3",",");
        jsonRedisTemplate.opsForSet().add("source_set",array);
        jsonRedisTemplate.opsForSet().add("dest_set","dest");
        jsonRedisTemplate.opsForSet().move("source_set","set1","dest_set");
        System.out.println(jsonRedisTemplate.opsForSet().members("dest_set"));
    }

    /**
     * 无序集合长度 Long size(K key);
     */
    @Test
    public void sizeTest(){
        String[] array = StringUtils.delimitedListToStringArray("set1,set1,set2,set3",",");
        jsonRedisTemplate.opsForSet().add("size_set",array);
        System.out.println(jsonRedisTemplate.opsForSet().size("size_set"));
    }

    /**
     * 判断member元素是否是集合key的成员 Boolean isMember(K key, Object o);
     */
    @Test
    public void memberTest(){
        String[] array = StringUtils.delimitedListToStringArray("set1,set1,set2,set3",",");
        jsonRedisTemplate.opsForSet().add("member_set",array);
        System.out.println(jsonRedisTemplate.opsForSet().isMember("member_set","set1"));
        System.out.println(jsonRedisTemplate.opsForSet().isMember("member_set","set7"));
    }
}
