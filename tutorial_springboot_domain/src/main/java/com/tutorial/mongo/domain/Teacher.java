package com.tutorial.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by jimmy on 2017/10/31.
 */
@Document
@Data
public class Teacher {
    @Id
    private Long id;

    private String name;

    private Integer age;

    List<Student> studentsList;

}
