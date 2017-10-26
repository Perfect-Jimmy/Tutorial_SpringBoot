package com.tutorial.mongo.service.impl;

import com.tutorial.mongo.domain.Student;
import com.tutorial.mongo.repository.StudentMonogRepository;
import com.tutorial.mongo.service.StudentMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jimmy on 2017/10/26.
 */
@Service
public class StudentMongoServiceImpl implements StudentMongoService{
    @Autowired
    private StudentMonogRepository studentMonogRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveStudent(Student student) {
        studentMonogRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMonogRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentMonogRepository.delete(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentMonogRepository.findByName(name);
    }

    @Override
    public Student findById(String id) {
        return studentMonogRepository.findOne(id);
    }

    @Override
    public List<Student> findStudent(Query query) {
        return mongoTemplate.find(query,Student.class);
    }
}
