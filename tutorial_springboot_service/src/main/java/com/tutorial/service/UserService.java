package com.tutorial.service;

import com.tutorial.domain.User;

/**
 * Created by jimmy on 2017/10/11.
 */
public interface UserService {

    public User findByUserName(String userName);

    public User saveOrUpdate(User user);
}
