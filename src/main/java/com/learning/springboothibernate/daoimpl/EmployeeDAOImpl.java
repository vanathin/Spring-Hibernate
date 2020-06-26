package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.Employee;
import com.learning.springboothibernate.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDAOImpl{

    @Autowired
    private EmployeeDAO empDAO;

    @Transactional
    public List<Employee> getAll(){
        return Optional.ofNullable(empDAO.findAll())
                .orElseGet(() -> new ArrayList<>());
    }

    public Employee getByName(){
        return Optional.ofNullable(empDAO.findByName("vanu", "IT"))
                .orElseGet(null);
    }

    /*Propagation.REQUIRED*/
    //@Transactional(propagation = Propagation.REQUIRED)
    public int saveOrUpdate(Employee emp){
        Optional<Employee> employee = empDAO.findById(emp.getId());
        if(employee.isPresent()){
            Employee empFromDB = employee.get();
            empFromDB.setAddress(emp.getAddress());
            empFromDB.setName(emp.getName());
            empFromDB.setType(emp.getType());
            empDAO.save(empFromDB);
            return empFromDB.getId();
        }else{
            empDAO.save(emp);
            return emp.getId();
        }
    }

    /*Propagation.REQUIRED*/
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(int id){
        Optional<Employee> employee = empDAO.findById(id);

        if(employee.isPresent())
        {
            empDAO.deleteById(id);
            return id;
        } else{
            return 0;
        }

    }

    /*Propagation.SUPPORTS*/
    /*@Transactional(propagation = Propagation.SUPPORTS)
    public int save(Employee emp){
        return Optional.ofNullable(empDAO.save(emp))
                .map(Employee::getId)
                .orElse(0);
    }*/
    /*Propagation.NOT_SUPPORTED*/
    /*@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int save(Employee emp){
        return Optional.ofNullable(empDAO.save(emp))
                .map(Employee::getId)
                .orElse(0);
    }*/
    /*Propagation.REQUIRES_NEW*/
    /*@Transactional(propagation = Propagation.REQUIRES_NEW)
    public int save(Employee emp){
        return Optional.ofNullable(empDAO.save(emp))
                .map(Employee::getId)
                .orElse(0);
    }*/
    /*Propagation.NEVER*/
    /*@Transactional(propagation = Propagation.NEVER)
    public int save(Employee emp){
        return Optional.ofNullable(empDAO.save(emp))
                .map(Employee::getId)
                .orElse(0);
    }*/
    /*Propagation.MANDATORY*/
    /*@Transactional(propagation = Propagation.MANDATORY)
    public int save(Employee emp){
        return Optional.ofNullable(empDAO.save(emp))
                .map(Employee::getId)
                .orElse(0);
    }*/


}
