package com.learning.springboothibernate.bean.onetoone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@Entity(name="PHONE")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PHONE_ID")
    private int id;

    @Column(name="number")
    private String number;
}
