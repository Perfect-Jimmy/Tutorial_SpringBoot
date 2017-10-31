package com.tutorial.mongo.repository;

import com.tutorial.mongo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jimmy on 2017/10/31.
 */
@Repository
public interface TeacherMongoRepository extends MongoRepository<Teacher, Long> {

    @Query("{'studentList.name':?0}")
    List<Teacher> findByStudentName(String name);
}
