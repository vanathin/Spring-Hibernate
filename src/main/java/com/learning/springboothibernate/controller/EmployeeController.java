package com.learning.springboothibernate.controller;

import com.learning.springboothibernate.bean.Employee;
import com.learning.springboothibernate.daoimpl.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.yaml.snakeyaml.util.UriEncoder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAOImpl daoImpl;

    @GetMapping(path="/employees")
    public List<Employee> getAll(){
        return daoImpl.getAll();
    }

    @GetMapping(path="/employeesByName")
    public Employee getByName(){
        return daoImpl.getByName();
    }


    @PostMapping(path="/employees")
    public ResponseEntity<Employee> save(@RequestBody Employee emp){
        int id = daoImpl.saveOrUpdate(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/employees/{empId}")
    public int delete(@PathVariable("empId") int empId){

        return daoImpl.delete(empId);
    }
}
