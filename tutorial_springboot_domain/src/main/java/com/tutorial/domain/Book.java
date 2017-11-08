package com.tutorial.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jimmy on 2017/10/13.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table
@Entity(name="book")
public class Book implements Serializable{

    @Id
    @Column(name = "id",unique = true,nullable = false,length = 32)
    @GenericGenerator(name = "uuidGenerator",strategy = "uuid.hex")
    @GeneratedValue(generator = "uuidGenerator")
    private String id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "user_id")
    private Long userId;

    public Book(Long userId,String name, Float price) {
        this.name = name;
        this.price = price;
        this.userId = userId;
    }

    public Book() {
    }
}
