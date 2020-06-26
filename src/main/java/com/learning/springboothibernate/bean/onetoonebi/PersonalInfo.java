package com.learning.springboothibernate.bean.onetoonebi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="PERSONAL_INFO")
@Table
public class PersonalInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    private String name;

    private String address;

    @OneToOne( cascade = CascadeType.ALL, mappedBy = "perInfo")// mappedBy indicates that bidirectional
    private EmployeeInfo emp;
}
