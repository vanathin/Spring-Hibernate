package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.onetoonejointable.Resource;
import com.learning.springboothibernate.bean.onetoonejointable.Worker;
import com.learning.springboothibernate.dao.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerDAOImpl {

    @Autowired
    private WorkerDAO workerDAO;

    @Autowired
    private ResourceDAOImpl resourceDAOImpl;

    /**
     * This method shows after calling workerDAO.save(worker), how worker1.setName("Name changed")
     * is reflecting in DB.
     */
    @Transactional
    public long saveOrUpdate(Worker worker) {
        workerDAO.save(worker);
        Optional<Worker> w = workerDAO.findById(worker.getId());
        w.ifPresent(worker1 -> worker1.setName("Name changed"));
        return worker.getId();
    }

    public List<Worker> getAllWorker() {
        return workerDAO.getAllWorker();
    }

    /**
    *  Rollback happens here because we have added rollbackFor checked exception.
    *  By default rollback happens for runtime exception.
    */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int rollBackForException(Worker worker) throws Exception {
        workerDAO.save(worker);
        Resource r = new Resource();
        if (null != worker.getWorkStation()) {
            r.setEmpName(worker.getName());
            r.setName(worker.getWorkStation().getName());
            resourceDAOImpl.saveResourceWithException(r);
        }
        return worker.getId();
    }

    //By default rollback won't happen for checked exception.
    @Transactional(propagation = Propagation.REQUIRED)
    public int noRollBackForException(Worker worker) throws Exception {
        workerDAO.save(worker);
        Resource r = new Resource();
        if (null != worker.getWorkStation()) {
            r.setEmpName(worker.getName());
            r.setName(worker.getWorkStation().getName());
            resourceDAOImpl.saveResourceWithException(r);
        }
        return worker.getId();
    }

    /**
    * By default roll back happens for runtime exception
    */
    @Transactional(propagation = Propagation.REQUIRED)
    public int rollBackForRunTimeException(Worker worker) {
        workerDAO.save(worker);
        Optional.ofNullable(worker.getWorkStation())
                .map(workStation -> {
                    Resource r = new Resource();
                    r.setEmpName(worker.getName());
                    r.setName(workStation.getName());
                    resourceDAOImpl.saveResourceWithRunTimeException(r);
                    return worker.getId();
                }).orElseGet(() -> null);
        return worker.getId();
    }

    //Success save operation
    @Transactional(propagation = Propagation.REQUIRED)
    public int propagationRequired(Worker worker) {
        workerDAO.save(worker);
        Resource r = new Resource();
        Optional.ofNullable(worker.getWorkStation())
                .map(workStation -> {
                    r.setEmpName(worker.getName());
                    r.setName(workStation.getName());
                    resourceDAOImpl.save(r);//If caller method has transactional, calling method use it, else new transaction created in calling method
                    return worker.getId();
                }).orElseGet(worker::getId);
        return worker.getId();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int propagationRequiredNew(final Worker worker) {
        return Optional.of(workerDAO.save(worker))
                .map(worker1 -> {
                    Optional.of(worker1)
                            .map(Worker::getWorkStation)
                            .ifPresent(workStation -> {
                                final Resource r = new Resource();
                                r.setEmpName(worker1.getName());
                                r.setName(workStation.getName());
                                resourceDAOImpl.propagationRequiredNew(r); //New Transaction created)
                            });
                    return worker1;
                })
                .map(Worker::getId)
                .orElseThrow(() -> new RuntimeException("Object persistent returned null."))
                ;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public int propagationSupport(Worker worker) {
        workerDAO.save(worker);
        Resource r = new Resource();
        Optional.ofNullable(worker.getWorkStation())
                .map(workStation -> {
                    r.setEmpName(worker.getName());
                    r.setName(workStation.getName());
                    resourceDAOImpl.propagationSupport(r); //Caller method should have Transaction, else calling method throws exception
                    return worker.getId();
                }).orElseGet(worker::getId);
        return worker.getId();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int propagationNotSupported(Worker worker) {
        workerDAO.save(worker);
        Resource r = new Resource();
        Optional.ofNullable(worker.getWorkStation())
                .map(workStation -> {
                    r.setEmpName(worker.getName());
                    r.setName(workStation.getName());
                    resourceDAOImpl.propagationNotSupported(r); //Caller method should not have Transaction, else calling method throws exception
                    return worker.getId();
                }).orElseGet(worker::getId);
        return worker.getId();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int propagationNever(Worker worker) {
        workerDAO.save(worker);
        Resource r = new Resource();
        Optional.ofNullable(worker.getWorkStation())
                .map(workStation -> {
                    r.setEmpName(worker.getName());
                    r.setName(workStation.getName());
                    resourceDAOImpl.propagationNever(r); //Caller method should not have Transaction, else calling method throws exception
                    return worker.getId();
                }).orElseGet(worker::getId);
        return worker.getId();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int propagationMandatory(Worker worker) {
        workerDAO.save(worker);
        Resource r = new Resource();
        Optional.ofNullable(worker.getWorkStation())
                .map(workStation -> {
                    r.setEmpName(worker.getName());
                    r.setName(workStation.getName());
                    resourceDAOImpl.propagationMandatory(r); //Caller method should have Transaction, else calling method throws exception
                    return worker.getId();
                }).orElseGet(worker::getId);
        return worker.getId();
    }

}
