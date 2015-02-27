package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.constants.AppConstants;
import com.ubiquitech.leaveTrack.domain.Request;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Map;

/**
 * vane created on 2014/12/08.
 */
public class RequestLeaveForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Valid
    protected Request request = new Request();

    protected Map<String, Object> map;

    @NotEmpty
    protected String startDate;

    @NotEmpty
    protected String endDate;

    protected String employeeName;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName.toUpperCase().trim();
    }
}