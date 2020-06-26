package com.learning.springboothibernate.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String address;

}
