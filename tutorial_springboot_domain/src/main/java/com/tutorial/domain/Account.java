package com.tutorial.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by jimmy on 2017/11/1.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table
@Entity(name="account")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=6,max=10)
    private String userName;

   // @Size(min=6,max=10)
    private String password;

    private String email;

}
