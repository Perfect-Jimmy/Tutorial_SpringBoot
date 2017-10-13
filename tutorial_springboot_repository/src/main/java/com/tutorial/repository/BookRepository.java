package com.tutorial.repository;

import com.tutorial.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jimmy on 2017/10/13.
 */
//@RepositoryDefinition(domainClass = Book.class,idClass = Long.class)
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    Book findById(Long id);
}
