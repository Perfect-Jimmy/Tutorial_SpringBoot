package com.tutorial.service.impl;

import com.tutorial.domain.User;
import com.tutorial.repository.UserRepository;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jimmy on 2017/10/11.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName,password);
    }

    @Override
    public List<User> findByUserNameOrPassword(String userName, String password) {
        return userRepository.findByUserNameOrPassword(userName,password);
    }

    @Override
    public Long countByUserName(String userName) {
        return userRepository.countByUserName(userName);
    }

    @Override
    public List<User> findByUserNameLike(String userName) {
        return userRepository.findByUserNameLike(userName);
    }

    @Override
    public List<User> findByUserNameIgnoreCase(String userName) {
        return userRepository.findByUserNameIgnoreCase(userName);
    }

    @Override
    public List<User> findByUserNameOrderByBirthDayDesc(String userName) {
        return userRepository.findByUserNameOrderByBirthDayDesc(userName);
    }

    @Override
    public Page<User> pageByUserName(Integer pageNum,Integer size,String userName) {
        Sort.Order idOrder = new Sort.Order(Sort.Direction.DESC, "id");
        Sort.Order nameOrder = new Sort.Order(Sort.Direction.ASC,"userName");
        Sort sort = new Sort(idOrder,nameOrder);
       // Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, size, sort);
        return userRepository.findByUserName(userName,pageable);
    }

    @Override
    @Transactional
    public void modifyUser(String userName, Long id) {
        userRepository.modifyUser(userName,id);
    }

    @Override
    @Transactional
    public void modifyUser(User user) {
        userRepository.modifyUser(user);
    }

    @Override
    public Page<User> queryUserByParam(String userName,Integer pageNum,Integer size) {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("id");
                Predicate predicate = cb.lt(path, 5);
                return predicate;
            }
        };

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum, size, sort);
        return userRepository.findAll(specification,pageable);
    }
}
