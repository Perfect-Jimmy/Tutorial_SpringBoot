package com.tutorial.service;

import com.tutorial.domain.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by jimmy on 2017/10/13.
 */
public interface BookService {

    public Book findByBookId(Long id);

    public Book saveOrUpdate(Book book);

    public Page<Book> pageBook(Float price, String name);

    public List<Book> findByUserId(Long userId);



}
