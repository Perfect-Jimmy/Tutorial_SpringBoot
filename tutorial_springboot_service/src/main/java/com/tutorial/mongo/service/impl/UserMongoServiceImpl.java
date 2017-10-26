package com.tutorial.mongo.service.impl;

import com.tutorial.domain.User;
import com.tutorial.mongo.service.UserMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jimmy on 2017/10/25.
 */
@Service
public class UserMongoServiceImpl implements UserMongoService{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<User> queryUser() {
        return null;
    }
}
