package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.constants.AppConstants;
import com.ubiquitech.leaveTrack.domain.Request;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Map;

/**
 * vane created on 2014/12/19.
 */
public class ProcessEmployeeLeaveForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    protected Request request = new Request();

    protected String employeeFullName;

    protected Map<String, Object> map;

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
        this.employeeFullName = employeeFullName;
    }
}