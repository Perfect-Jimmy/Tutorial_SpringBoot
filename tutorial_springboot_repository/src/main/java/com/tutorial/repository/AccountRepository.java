package com.tutorial.repository;

import com.tutorial.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by jimmy on 2017/11/1.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>,JpaSpecificationExecutor<Account> {
}
