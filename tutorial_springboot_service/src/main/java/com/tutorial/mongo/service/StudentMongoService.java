package com.tutorial.mongo.service;

import com.tutorial.mongo.domain.Student;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by jimmy on 2017/10/26.
 */
public interface StudentMongoService {
    public void saveStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
    public List<Student> findByName(String name);
    public Student findById(String id);

    public List<Student> findStudent(Query query);
}
