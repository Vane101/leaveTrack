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
    String employeeName;
    String supervisorName;
    Long requestId;

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

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
