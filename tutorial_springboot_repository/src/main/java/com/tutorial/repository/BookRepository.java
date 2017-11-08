package com.tutorial.repository;

import com.tutorial.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by jimmy on 2017/10/13.
 */
//@RepositoryDefinition(domainClass = Book.class,idClass = Long.class)
@Repository
public interface BookRepository extends JpaRepository<Book, Long>,JpaSpecificationExecutor<Book> {

    Book findById(Long id);

  /*  @Query(value = "select Book from Book n where n.price =?1",
            countQuery = "select count(*) from Book n where n.price =?1",
            nativeQuery = false)*/
   // Page<Book> pageBook(Float price,String name, Pageable pageable);

    @Query(value = "SELECT * FROM book WHERE user_id = :userId",nativeQuery = true)
    List<Book> findByUserId(@Param("userId") Long userId);

    Book findByName(String name);
}
