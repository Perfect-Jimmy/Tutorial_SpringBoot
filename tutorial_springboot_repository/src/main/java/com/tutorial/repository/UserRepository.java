package com.tutorial.repository;

import com.tutorial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jimmy on 2017/10/11.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
