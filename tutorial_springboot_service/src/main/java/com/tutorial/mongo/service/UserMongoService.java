package com.tutorial.mongo.service;

import com.tutorial.domain.User;

import java.util.List;

/**
 * Created by jimmy on 2017/10/25.
 */
public interface UserMongoService {

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public List<User> queryUser();
}
