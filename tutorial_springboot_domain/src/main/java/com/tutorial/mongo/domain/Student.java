package com.tutorial.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jimmy on 2017/10/26.
 */
@Document
@Data
public class Student {
    @Id
    public String id;

    public String name;

    public Integer age;

    public String[] hobbyArray;

}
