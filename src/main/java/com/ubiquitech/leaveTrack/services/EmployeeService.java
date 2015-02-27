package com.ubiquitech.leaveTrack.services;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.form.QueryEmployeeForm;

import java.util.List;

/**
 * vane created on 2014/11/20.
 */
public interface EmployeeService {
    public void createEmployee(Employee employee);

    public List<Object[]> getEmployeeNames();

    public Boolean checkUsername(String userName);

    public Employee getEmployee(String username);

    public Employee getEmployeeById(Long id);

    public List getQueriedEmployees(QueryEmployeeForm queryEmployeeForm);

}
