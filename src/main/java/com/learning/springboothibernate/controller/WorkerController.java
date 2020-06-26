package com.learning.springboothibernate.controller;

import com.learning.springboothibernate.bean.onetoone.Staff;
import com.learning.springboothibernate.bean.onetoonejointable.Worker;
import com.learning.springboothibernate.daoimpl.StaffDAOImpl;
import com.learning.springboothibernate.daoimpl.WorkerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    private WorkerDAOImpl daoImpl;

    @PostMapping(path="/workers")
    public ResponseEntity<Staff> save(@RequestBody Worker emp){
        long id = daoImpl.saveOrUpdate(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/WorkersAll")
    public List<Worker> getAll(){
        return daoImpl.getAllWorker();
    }

}
