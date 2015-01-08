package com.ubiquitech.leaveTrack.services;

import com.ubiquitech.leaveTrack.domain.Employee;

import java.util.List;

/**
 * Created by vane on 2014/11/20.
 */
public interface EmployeeService {
    public void createEmployee(Employee employee);
    public  List<Object[]> getEmployeeNames();
    public Boolean checkUsername(String userName);
    public Employee getEmployee(String username);
    public String getSupervisorEmail(Long id);
    public String getEmployeeName(Long id);

}
