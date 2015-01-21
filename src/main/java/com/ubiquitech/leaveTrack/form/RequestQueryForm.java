package com.ubiquitech.leaveTrack.form;

import com.ubiquitech.leaveTrack.domain.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vane on 2015/01/20.
 */
public class RequestQueryForm implements Serializable {
    private static final long serialVersionUID=1L;
    String state;
    String leaveType;
    String employeeFirstName;
    String employeeLastName;
    String supervisorFirstName;
    String supervisorLastName;
    Long  requestId;
    protected Map<String, Object> map = new HashMap<String, Object>();
    protected Request request = new Request();
    String employeeFullName;
    String supervisorFullName;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getSupervisorFirstName() {
        return supervisorFirstName;
    }

    public void setSupervisorFirstName(String supervisorFirstName) {
        this.supervisorFirstName = supervisorFirstName;
    }

    public String getSupervisorLastName() {
        return supervisorLastName;
    }

    public void setSupervisorLastName(String supervisorLastName) {
        this.supervisorLastName = supervisorLastName;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Map<String, Object> getMap() {
        List<String> stateList = new ArrayList<String>();
        stateList.add("Logged");
        stateList.add("Approved");
        stateList.add("Rejected");

        List<String> leaveTypeList = new ArrayList<String>();
        leaveTypeList.add("Annual Leave");
        leaveTypeList.add("Sick Leave");
        leaveTypeList.add("Maternity Leave");
        leaveTypeList.add("Family Leave");

        map = new HashMap<String, Object>();
        map.put("stateList", stateList);
        map.put("leaveTypeList", leaveTypeList);
        return map;
    }

    public void setMap(Map<String, Object> map) {

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

    public String getSupervisorFullName() {
        return supervisorFullName;
    }

    public void setSupervisorFullName(String supervisorFullName) {
        this.supervisorFullName = supervisorFullName;
    }
}
