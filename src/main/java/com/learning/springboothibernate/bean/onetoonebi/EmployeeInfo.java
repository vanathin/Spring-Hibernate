package com.learning.springboothibernate.bean.onetoonebi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="EMP_INFO")
@Table
public class EmployeeInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    private String empId;

    private String depName;

    private String exp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_id") // Owning class and foreign key to refer associated tbl
    private PersonalInfo perInfo;
}
