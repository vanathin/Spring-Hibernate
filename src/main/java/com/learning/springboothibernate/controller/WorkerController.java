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
    public ResponseEntity<Worker> save(@RequestBody Worker emp){
        long id = daoImpl.saveOrUpdate(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path="/rollBackForRunTimeException")
    public ResponseEntity<Worker> rollBackForRunTimeException(@RequestBody Worker emp){
        long id = daoImpl.rollBackForRunTimeException(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path="/rollBackForException")
    public ResponseEntity<Worker> rollBackForException(@RequestBody Worker emp)  throws Exception{
        long id = daoImpl.rollBackForException(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path="/noRollBackForExp")
    public ResponseEntity<Worker> noRollBackForException(@RequestBody Worker emp)  throws Exception{
        long id = daoImpl.noRollBackForException(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @PostMapping(path="/propagationRequired")
    public ResponseEntity<Worker> propagationRequired(@RequestBody Worker emp){
        long id = daoImpl.propagationRequired(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path="/propagationSupport")
    public ResponseEntity<Worker> propagationSupport(@RequestBody Worker emp){
        long id = daoImpl.propagationSupport(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path="/propagationNotSupported")
    public ResponseEntity<Worker> propagationNotSupported(@RequestBody Worker emp){
        long id = daoImpl.propagationNotSupported(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path="/propagationRequiredNew")
    public ResponseEntity<Worker> propagationRequiredNew(@RequestBody Worker emp){
        long id = daoImpl.propagationRequiredNew(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path="/propagationNever")
    public ResponseEntity<Worker> propagationNever(@RequestBody Worker emp){
        long id = daoImpl.propagationNever(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping(path="/propagationMandatory")
    public ResponseEntity<Worker> propagationMandatory(@RequestBody Worker emp){
        long id = daoImpl.propagationMandatory(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    //MANDATORY
    @GetMapping("/WorkersAll")
    public List<Worker> getAll(){
        return daoImpl.getAllWorker();
    }

}
