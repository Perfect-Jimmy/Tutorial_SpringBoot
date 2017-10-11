package com.tutorial.service.impl;

import com.tutorial.domain.User;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jimmy on 2017/10/11.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
}
