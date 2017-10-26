package com.tutorial.mongo.repository;

import com.tutorial.mongo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jimmy on 2017/10/26.
 */
//@RepositoryRestResource(collectionResourceRel = "student", path = "student")
@Repository
public interface StudentMonogRepository extends MongoRepository<Student, String> {
    List<Student> findByName(@Param("name") String name);
}
