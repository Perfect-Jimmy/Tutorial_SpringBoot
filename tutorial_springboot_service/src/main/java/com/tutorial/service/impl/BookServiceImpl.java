package com.tutorial.service.impl;

import com.tutorial.domain.Book;
import com.tutorial.repository.BookRepository;
import com.tutorial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Page<Book> pageBook(Float price, String name) {
        Sort.Order idOrder = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(idOrder);
        // Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(1, 1, sort);
        return bookRepository.pageBook(price,name,pageable);

    }

    @Override
    public List<Book> findByUserId(Long userId) {
        return bookRepository.findByUserId(userId);
    }
}
