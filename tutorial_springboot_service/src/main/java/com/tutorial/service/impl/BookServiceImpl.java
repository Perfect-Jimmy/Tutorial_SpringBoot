package com.tutorial.service.impl;

import com.tutorial.domain.Book;
import com.tutorial.repository.BookRepository;
import com.tutorial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jimmy on 2017/10/13.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book findByBookId(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return bookRepository.save(book);
    }
}
