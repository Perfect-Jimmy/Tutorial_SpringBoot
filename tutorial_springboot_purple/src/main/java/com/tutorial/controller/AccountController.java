package com.tutorial.controller;

import com.tutorial.domain.Account;
import com.tutorial.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jimmy on 2017/11/1.
 */
@RestController
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "account",method = RequestMethod.POST)
    public String saveAccount(@Validated @RequestBody Account account){
        System.out.println("-============================");
        logger.info("account save");
        accountService.saveAccount(account);
       // ResultMsg resultMsg = new ResultMsg();
        return "success";
    }
}
