package com.tutorial.controller;

import com.google.common.collect.Lists;
import com.tutorial.domain.Book;
import com.tutorial.domain.User;
import org.mockito.internal.util.collections.Sets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by jimmy on 2017/11/3.
 * http://blog.csdn.net/zrk1000/article/details/72667478
 */
@Controller
public class ThymeleafController {

    /**
     * thymeleaf 基本应用
     * @param model
     * @return
     */
    @RequestMapping(value="/thymeleafHello",method = RequestMethod.GET)
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
        return "/thymeleaf/thymeleafHello";
    }

    /**
     * thymeleaf 内置工具类
     * @param model
     * @return
     */
    @RequestMapping(value="/thymeleafUtility",method = RequestMethod.GET)
    public String bookTheme(Model model){
        User user = new User();
        user.setId(1L);
        user.setUserName("Jimmy");
        user.setBirthDay(new Date());
        user.setInCome(100L);
        model.addAttribute("user", user);

        List<String> list = Lists.newArrayList();
        list.add("java");
        list.add("react");
        model.addAttribute("list", list);

        Set<String> set = Sets.newSet();
        set.add("wuxi");
        set.add("shanghai");
        set.add("北京");
        model.addAttribute("set", set);
        return "/thymeleaf/thymeleafUtility";
    }
}
