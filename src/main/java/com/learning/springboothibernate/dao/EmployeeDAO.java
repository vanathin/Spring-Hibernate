package com.learning.springboothibernate.dao;

import com.learning.springboothibernate.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.name = :name and e.type = :type")
    Employee findByName(@Param("name") String name, @Param("type")String type);
}
