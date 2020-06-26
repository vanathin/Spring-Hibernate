package com.learning.springboothibernate.dao;

import com.learning.springboothibernate.bean.onetoone.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDAO extends JpaRepository<Staff, Integer> {
}
