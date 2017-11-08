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

     @Scheduled(fixedRate = 5000)
     public void sync(){
         List<String> list = Lists.newArrayList();
         list.add("book1");
         list.add("book2");
         list.add("book3");
         list.add("book4");
         list.add("book1");
         taskExecutor.execute(new CheckSaveName(list));
    }

    class CheckSaveName implements Runnable{
        private List<String> list;

        public CheckSaveName(List<String> list){
            this.list = list;
        }
        @Override
        public void run() {
            for(String name:list){
                Book book = bookService.findByBookName(name);
                if(book == null){
                    logger.info("sync book name{}",name);
                    book = new Book();
                    book.setName(name);
                    book.setPrice(20F);
                    book.setUserId(1L);
                    bookService.saveOrUpdate(book);
                }
            }
        }
    }
}
