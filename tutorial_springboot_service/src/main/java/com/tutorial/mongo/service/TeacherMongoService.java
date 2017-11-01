package com.tutorial.mongo.service;

import com.tutorial.mongo.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by jimmy on 2017/10/31.
 */
public interface TeacherMongoService {
    public void saveTeacher(Teacher teacher);
    public List<Teacher> queryTeacher(Query query);

    public List<Teacher> queryByStudentName(String name);

    public Long count(Query query);

    public Page<Teacher> findByNameLike(String name, int pageNum,int pageSize);

    public Page<Teacher> queryPage();
}
