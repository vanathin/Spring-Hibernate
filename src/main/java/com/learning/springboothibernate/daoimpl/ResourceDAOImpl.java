package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.onetoonejointable.Resource;
import com.learning.springboothibernate.dao.ResouceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResourceDAOImpl{

    @Autowired
    private ResouceDAO resourceDAO;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveResourceWithException(Resource resource) throws Exception {
         throw new Exception();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int saveResourceWithRunTimeException(Resource resource){
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Resource resource){
        resourceDAO.save(resource);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void propagationRequiredNew(Resource resource){
        resourceDAO.save(resource);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void propagationSupport(Resource resource){
        resourceDAO.save(resource);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported(Resource resource){
        resourceDAO.save(resource);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void propagationNever(Resource resource){
        resourceDAO.save(resource);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void propagationMandatory(Resource resource){
        resourceDAO.save(resource);
    }

}
