package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.onetoone.Staff;
import com.learning.springboothibernate.bean.onetoonejointable.Worker;
import com.learning.springboothibernate.dao.WorkerDAO;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerDAOImpl {

    @Autowired
    private WorkerDAO workerDAO;

    public long saveOrUpdate(Worker worker){
        workerDAO.save(worker);
        return worker.getId();
    }

    public List<Worker> getAllWorker(){
        return workerDAO.getAllWorker();
    }
}
