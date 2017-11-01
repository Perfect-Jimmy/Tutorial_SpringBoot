package com.tutorial.service.impl;

import com.tutorial.domain.Account;
import com.tutorial.repository.AccountRepository;
import com.tutorial.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jimmy on 2017/11/1.
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
