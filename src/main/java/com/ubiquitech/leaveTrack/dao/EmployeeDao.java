package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Employee;

import java.util.List;

/**
 * Created by vane on 2014/11/20.
 */
public interface EmployeeDao {
    public void createEmployee(Employee emp);
    public List<Object[]> getEmployeeNames();
    public Boolean checkUsername(String username);
    public Employee getEmployee(String username);
    public Employee getEmployeeById(Long id);
}
