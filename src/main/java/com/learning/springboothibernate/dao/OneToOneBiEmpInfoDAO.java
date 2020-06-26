package com.learning.springboothibernate.dao;

import com.learning.springboothibernate.bean.onetoonebi.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToOneBiEmpInfoDAO extends JpaRepository<EmployeeInfo, Integer> {
}
