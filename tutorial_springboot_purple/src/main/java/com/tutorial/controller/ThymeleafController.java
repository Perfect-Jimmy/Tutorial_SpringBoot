package com.tutorial.controller;

import com.google.common.collect.Lists;
import com.tutorial.domain.Book;
import com.tutorial.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by jimmy on 2017/11/3.
 */
@Controller
public class ThymeleafController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String helloTheme(Model model){
        User user = new User();
        user.setId(1L);
        user.setUserName("Jimmy");
        user.setBirthDay(new Date());
        user.setInCome(100L);
        model.addAttribute("user",user);
        model.addAttribute("name", "world");

        List<Book> list = Lists.newArrayList();
        for(int i=0;i<5;i++){
            Book book = new Book();
            book.setId(String.valueOf(i+1));
            book.setName("book"+(i+1));
            book.setUserId(1L);
            list.add(book);
        }
        model.addAttribute("books", list);
        return "/welcome";
    }
}
