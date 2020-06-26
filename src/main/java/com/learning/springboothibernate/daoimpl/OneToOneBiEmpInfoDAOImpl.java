package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.onetoone.Staff;
import com.learning.springboothibernate.bean.onetoonebi.EmployeeInfo;
import com.learning.springboothibernate.dao.OneToOneBiEmpInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneToOneBiEmpInfoDAOImpl {

    @Autowired
    private OneToOneBiEmpInfoDAO empInfo;

    public int saveOrUpdate(EmployeeInfo staff){
        empInfo.save(staff);
        return staff.getId();
    }
}
