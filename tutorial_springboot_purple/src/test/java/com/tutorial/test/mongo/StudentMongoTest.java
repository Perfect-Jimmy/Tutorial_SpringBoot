package com.tutorial.test.mongo;

import com.tutorial.mongo.domain.Student;
import com.tutorial.mongo.service.StudentMongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by jimmy on 2017/10/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class StudentMongoTest {
    @Autowired
    private StudentMongoService studentMongoService;

    @Test
    public void saveStudentMongoTest(){
       /* Student student = new Student();
        student.setName("Jimmy");
        student.setAge(20);
        System.out.println(StringUtils.delimitedListToStringArray("看书,打球",","));
        student.setHobbyArray(StringUtils.delimitedListToStringArray("看书,打球",","));
        studentMongoService.saveStudent(student);*/
       for(int i=0;i<100;i++){
           Student student = new Student();
           student.setName("Jimmy"+i);
           student.setAge(i+1);
           student.setHobbyArray(StringUtils.delimitedListToStringArray("看书,打球",","));
           studentMongoService.saveStudent(student);
       }
    }

    @Test
    public void deleteStudentMongoTest(){
        /*Student student = new Student();
        student.setId("100");
        studentMongoService.saveStudent(student);*/

        studentMongoService.deleteStudent(studentMongoService.findById("100"));
    }

    @Test
    public void findByNameTest(){
        List<Student> student = studentMongoService.findByName("Jimmy");
        System.out.println(student);
    }

    //查询
    @Test
    public void queryTest(){
        Query query = new Query();
        Criteria criteria = new Criteria();
        //查询name=
        //query.addCriteria(Criteria.where("name").is("Jimmy"));

        //查询age大于50
        //query.addCriteria(Criteria.where("age").gt(50));

        //查询name= and age=
        //query.addCriteria(Criteria.where("name").is("Jimmy").and("age").is(20));

        //查询name= or age=
        //query.addCriteria(new Criteria().orOperator(Criteria.where("name").is("Jimmy"),Criteria.where("age").is(20)));






        System.out.println(query.toString());
        System.out.println(studentMongoService.findStudent(query));
    }
}
