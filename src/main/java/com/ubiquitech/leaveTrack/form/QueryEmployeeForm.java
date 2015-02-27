package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Employee;
import com.ubiquitech.leaveTrack.domain.Request;

import java.io.Serializable;

/**
 * vane created on 2015/02/23.
 */
public class QueryEmployeeForm implements Serializable{
    private static final long serialVersionUID=1L;

    protected Request request = new Request();
    protected Employee employee = new Employee();

    String employeeName;
    String supervisorName;
    String jobTitle;
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toUpperCase().trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle.toUpperCase().trim();
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName.toUpperCase().trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName.toUpperCase().trim();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
