package com.tutorial.scheduler;

import com.google.common.collect.Lists;
import com.tutorial.domain.Book;
import com.tutorial.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jimmy on 2017/11/8.
 * 1.主类 @EnableScheduling
 * 2.方法 @Scheduled(fixedRate = 5000)
 */
 @Component
public class SyncBookName {
     private static final Logger logger = LoggerFactory.getLogger(SyncBookName.class);
     @Autowired
     private BookService bookService;
     @Autowired
     private ThreadPoolTaskExecutor taskExecutor;


   // @Scheduled(fixedRate = 5000)
    public void  syncBook(){
        logger.info("同步book name");
        final List<String> list = Lists.newArrayList();
        list.add("book1");
        list.add("book2");
        list.add("book3");
        list.add("book4");
        list.add("book5");
        list.add("book1");
        final Lock lock = new ReentrantLock();
        for(final String name:list){
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    if(list.size()>0){
                        lock.lock();
                        System.out.println(Thread.currentThread().getName()+"===="+name);
                        Book book = bookService.findByBookName(name);
                        if(book == null){
                            logger.info("sync book name{}",name);
                            book = new Book();
                            book.setName(name);
                            book.setPrice(20F);
                            book.setUserId(1L);
                            bookService.saveOrUpdate(book);
                        }
                        lock.unlock();
                    }
                }
            });
        }
        System.out.println("--------------------------------------------");
    }

}
