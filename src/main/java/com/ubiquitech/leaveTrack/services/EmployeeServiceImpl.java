package com.ubiquitech.leaveTrack.services;

import com.ubiquitech.leaveTrack.dao.EmployeeDao;
import com.ubiquitech.leaveTrack.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vane on 2014/11/20.
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
    EmployeeDao employeeDao;

    @Transactional // this is the only method in this class that needs to be transactional
    @Override
    public void createEmployee(Employee employee) {
      employeeDao.createEmployee(employee);
    }

    @Override
    public List<Object[]> getEmployeeNames() {
    return employeeDao.getEmployeeNames();
    }

    @Override
    public Boolean checkUsername(String userName) {
        return employeeDao.checkUsername(userName);
    }

    @Override
    public Employee getEmployee(String username) {
        return employeeDao.getEmployee(username);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }
}
