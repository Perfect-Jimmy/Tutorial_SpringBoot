package com.tutorial.service;

import com.tutorial.domain.Book;

/**
 * Created by jimmy on 2017/10/13.
 */
public interface BookService {

    public Book findByBookId(Long id);

    public Book saveOrUpdate(Book book);
}
