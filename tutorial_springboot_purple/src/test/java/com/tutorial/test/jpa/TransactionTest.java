package com.tutorial.test.jpa;

import com.tutorial.domain.Book;
import com.tutorial.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jimmy on 2017/11/8.
 * 事物测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {
    @Autowired
    private BookService bookService;

    @Test
    @Transactional
    public void transactionTest(){

        bookService.saveOrUpdate(new Book(1L,"1111",20f));
        bookService.saveOrUpdate(new Book(1L,"2222",20f));
        bookService.saveOrUpdate(new Book(1L,"33333333333111",20f));
        bookService.saveOrUpdate(new Book(1L,"4444",20f));
    }
}
