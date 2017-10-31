package com.tutorial.mongo.service.impl;

import com.tutorial.mongo.domain.Student;
import com.tutorial.mongo.domain.Teacher;
import com.tutorial.mongo.repository.TeacherMongoRepository;
import com.tutorial.mongo.service.TeacherMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jimmy on 2017/10/31.
 */
@Service
public class TeacherMongoServiceImpl implements TeacherMongoService{
    @Autowired
    private TeacherMongoRepository teacherMongoRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherMongoRepository.save(teacher);
    }

    @Override
    public List<Teacher> queryTeacher(Query query) {
        return mongoTemplate.find(query,Teacher.class);
    }

    @Override
    public List<Teacher> queryByStudentName(String name) {
        return teacherMongoRepository.findByStudentName(name);
    }

    @Override
    public Long count(Query query) {
        return mongoTemplate.count(query, Student.class);
    }
}
