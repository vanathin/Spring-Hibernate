package com.learning.springboothibernate.daoimpl;

import com.learning.springboothibernate.bean.onetoone.Staff;
import com.learning.springboothibernate.dao.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffDAOImpl {

    @Autowired
    private StaffDAO staffDAO;

    public long saveOrUpdate(Staff staff){
        boolean isPresent = staffDAO.existsById(staff.getId());
        staffDAO.save(staff);
        return staff.getId();
        }
}
