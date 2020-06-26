package com.learning.springboothibernate.dao;

import com.learning.springboothibernate.bean.onetoonejointable.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerDAO extends JpaRepository<Worker, Integer> {

    @Query("SELECT e, w.floor FROM WORKER e " +
            "LEFT JOIN e.workStation w")
    List<Worker> getAllWorker();
}
