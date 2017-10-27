package com.tutorial.test.jpa;

import com.tutorial.domain.Book;
import com.tutorial.domain.User;
import com.tutorial.service.BookService;
import com.tutorial.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by jimmy on 2017/10/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @Test
    public void saveBookTest(){
        User user = userService.findById(2L);
        Book book = new Book();
        book.setPrice(101F);
        book.setName("c++");
        book.setUserId(user.getId());
        bookService.saveOrUpdate(book);
    }

    @Test
    public void pageBookTest(){

        bookService.pageBook(101F,"java") ;
    }

    @Test
    public void findByUserIdTest(){

        List<Book> list = bookService.findByUserId(1L);
        System.out.println(list);
    }
}
