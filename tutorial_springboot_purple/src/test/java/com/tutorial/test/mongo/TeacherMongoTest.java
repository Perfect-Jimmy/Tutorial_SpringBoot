package com.tutorial.test.mongo;

import com.google.common.collect.Lists;
import com.tutorial.mongo.domain.Student;
import com.tutorial.mongo.domain.Teacher;
import com.tutorial.mongo.service.TeacherMongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by jimmy on 2017/10/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class TeacherMongoTest {
    @Autowired
    private TeacherMongoService teacherMongoService;

    @Test
    public void saveTeacher(){
        for(Long i=1L;i<21;i++){
            Teacher teacher = new Teacher();
            teacher.setId(i);
            teacher.setName("teacher"+i);
            Student student = new Student();
            student.setId("ss_"+i);
            student.setName("ss_name_"+i);
            List<Student> students = Lists.newArrayList();
            students.add(student);
            teacher.setStudentsList(students);
            teacherMongoService.saveTeacher(teacher);
        }
    }

    @Test
    public void findByStudentName(){
        System.out.println(teacherMongoService.queryByStudentName("ss_name_1"));
    }
    @Test
    public void queryTeacher(){
        Query query = new Query();
        //模糊查询regex
        //query.addCriteria(Criteria.where("name").regex("1"));

        //分级查询
        //query.addCriteria(Criteria.where("studentsList.id").regex("ss_1"));//1,10,11,12,13,14,15,16,17,18,19
        //query.limit(3).skip(0);//1,10,11
        //query.limit(3).skip(2);//11,12,13

        //排序
       // query.addCriteria(Criteria.where("studentsList.id").regex("ss_1")).with(new Sort(new Sort.Order(Sort.Direction.DESC, "id")));


        System.out.println(teacherMongoService.queryTeacher(query));
    }

    //
    @Test
    public void count(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("1"));
        System.out.println(teacherMongoService.count(query));
    }

    //分页查询--jpa命名规范
    @Test
    public void findByNameLike(){
        Page<Teacher> page =  teacherMongoService.findByNameLike("teacher",0,4);
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getContent());
    }

    /**
     * 分页
     */
    @Test
    public void pageTest(){
        System.out.println(teacherMongoService.queryPage());
    }
}
