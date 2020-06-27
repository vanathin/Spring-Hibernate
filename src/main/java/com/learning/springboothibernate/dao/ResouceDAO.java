package com.learning.springboothibernate.dao;

import com.learning.springboothibernate.bean.onetoonejointable.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResouceDAO extends JpaRepository<Resource, Integer> {


}
