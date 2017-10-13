package com.tutorial.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jimmy on 2017/10/11.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(name="password",nullable = false,length = 18)
    private String passWord;

    /*编程语言中字符串一般都用String表示，但是数据库中varcahr数值类型有长度限制，一旦需要大文本，则需要text数    值类型*/
    @Column(columnDefinition="text")
    private String userDesc;

    /*不隐射成列*/
    @Transient
    private Long inCome;

    /*不加注解也会隐射成列*/
    private String address;


    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date birthDay;

}
