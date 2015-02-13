package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.constants.AppConstants;
import com.ubiquitech.leaveTrack.domain.Request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * vane created on 2015/01/20.
 */
public class QueryRequestForm implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Map<String, Object> map = new HashMap<String, Object>();
    protected Request request = new Request();
    String state;
    String leaveType;
    String employeeFirstName;
    String employeeLastName;
    String supervisorFirstName;
    String supervisorLastName;
    Long requestId;
    String employeeFullName;
    String supervisorFullName;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state.toUpperCase().trim();
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType.toUpperCase().trim();
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName.toUpperCase().trim();
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName.toUpperCase().trim();
    }

    public String getSupervisorFirstName() {
        return supervisorFirstName;
    }

    public void setSupervisorFirstName(String supervisorFirstName) {
        this.supervisorFirstName = supervisorFirstName.toUpperCase().trim();
    }

    public String getSupervisorLastName() {
        return supervisorLastName;
    }

    public void setSupervisorLastName(String supervisorLastName) {
        this.supervisorLastName = supervisorLastName.toUpperCase().trim();
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Map<String, Object> getMap() {
        AppConstants map=new AppConstants();
        return map.getMap();
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName.toUpperCase().trim();
    }

    public String getSupervisorFullName() {
        return supervisorFullName;
    }

    public void setSupervisorFullName(String supervisorFullName) {
        this.supervisorFullName = supervisorFullName.toUpperCase().trim();
    }
}
