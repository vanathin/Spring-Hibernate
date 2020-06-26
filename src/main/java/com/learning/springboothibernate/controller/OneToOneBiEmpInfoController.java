package com.learning.springboothibernate.controller;

import com.learning.springboothibernate.bean.onetoone.Staff;
import com.learning.springboothibernate.bean.onetoonebi.EmployeeInfo;
import com.learning.springboothibernate.daoimpl.OneToOneBiEmpInfoDAOImpl;
import com.learning.springboothibernate.daoimpl.StaffDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class OneToOneBiEmpInfoController {

    @Autowired
    private OneToOneBiEmpInfoDAOImpl daoImpl;

    @PostMapping(path="/onetoonebi")
    public ResponseEntity<Staff> save(@RequestBody EmployeeInfo emp){
        long id = daoImpl.saveOrUpdate(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
