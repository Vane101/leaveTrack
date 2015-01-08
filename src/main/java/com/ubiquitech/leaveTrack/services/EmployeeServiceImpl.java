package com.ubiquitech.leaveTrack.services;

import com.ubiquitech.leaveTrack.dao.EmployeeDao;
import com.ubiquitech.leaveTrack.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vane on 2014/11/20.
 */

//@Service("employeeService")
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
    EmployeeDao employeeDao;
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
    public String getSupervisorEmail(Long id) {
        return employeeDao.getSupervisorEmail(id);
    }

    @Override
    public String getEmployeeName(Long id) {
        return employeeDao.getEmployeeName(id);
    }
}
