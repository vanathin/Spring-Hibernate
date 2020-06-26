package com.learning.springboothibernate.bean.onetoone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    @Column(name="STAFF_NAME")
    private String staffName;


    @OneToOne(cascade=CascadeType.ALL)//one-to-one
    @JoinColumn(name="PHONE_ID")
    private Phone phone;// now owning entity

}
