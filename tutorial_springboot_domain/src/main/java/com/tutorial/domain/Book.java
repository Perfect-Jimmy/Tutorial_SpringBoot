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
    @Column(name = "id",unique = true,nullable = false,length = 18)
    @GenericGenerator(name = "uuidGenerator",strategy = "uuid.hex")
    @GeneratedValue(generator = "uuidGenerator")
    private Long id;

    @Column(name = "price")
    private Float price;


}
