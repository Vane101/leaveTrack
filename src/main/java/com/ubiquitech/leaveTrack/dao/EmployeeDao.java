package com.ubiquitech.leaveTrack.dao;

import com.ubiquitech.leaveTrack.domain.Employee;

import java.util.List;

/**
 * vane created on 2014/11/20.
 */
public interface EmployeeDao {
    void createEmployee(Employee emp);

    List<Object[]> getEmployeeNames();

    Boolean checkUsername(String username);

    Employee getEmployee(String username);

    Employee getEmployeeById(Long id);
}
